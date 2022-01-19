package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;
import domain.entity.transaction.Card;
import domain.entity.transaction.TransactionInfo;
import domain.repository.TransactionInfoRepositoryInterface;

public class TransactionInfoRepositoryImpl extends BaseRepository implements TransactionInfoRepositoryInterface{
    /**
     * add new transaction info to database
     * also add the card used for this transaction to database
     * @param ivID invoiceID
     * @param card
     * @throws SQLException
     */
    @Override
    public void newTransactionDB(int ivID, Card card, TransactionInfo transactionInfo) throws SQLException {
         Statement stm = EcoBikeRental.getConnection().createStatement();
         String invoiceID = Integer.toString(ivID);
         String cardID = Integer.toString(newCardDB(card));
         String createdDate = "\'" + transactionInfo.getCreatedAt() + "\'";
         String content = "\'" + transactionInfo.getTransactionContent() + "\'";
         String amount = Integer.toString(transactionInfo.getAmount());
         stm.execute("INSERT INTO TransactionInfo(cardID, invoiceID, createdDate, content, amount) "
                 + "VALUES (" + cardID + "," + invoiceID + "," + createdDate + "," + content + "," + amount + ");");
        int id = -1;
        ResultSet res = stm.executeQuery("SELECT id from TransactionInfo");
        while (res.next()) {
            id = res.getInt("id");
        }
        transactionInfo.setId(id);
    }

    private int newCardDB(Card card) throws SQLException {
        int currentCardID = -1;
        Statement stm = EcoBikeRental.getConnection().createStatement();
        String owner = "\'" + card.getOwner() + "\'";
        String cvvCode = "\'" + card.getCvvCode() + "\'";
        String cardCode = "\'" + card.getCardCode() + "\'";
        String dateExpired = "\'" + card.getDateExpired() + "\'";
        ResultSet res = stm.executeQuery("SELECT id from Card where owner = " + owner +
                " AND cvvCode =" + cvvCode + " AND cardCode =" + cardCode + " AND dateExpired = " + dateExpired);
        if (!res.isBeforeFirst()) {
            stm.execute("INSERT INTO Card(owner, cvvCode, cardCode, dateExpired) VALUES (" + owner + "," + cvvCode + "," + cardCode + "," + dateExpired + ");");
            res = stm.executeQuery("SELECT id from Card");
            while (res.next()) {
                currentCardID = res.getInt("id");
            }
        } else {
            res.next();
            currentCardID = res.getInt("id");
        }
        return currentCardID;
    }
    
}

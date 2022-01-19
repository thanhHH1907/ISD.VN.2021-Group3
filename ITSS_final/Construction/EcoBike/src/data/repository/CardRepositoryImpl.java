package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;
import domain.entity.transaction.Card;
import domain.repository.CardRepositoryInterface;

public class CardRepositoryImpl extends BaseRepository implements CardRepositoryInterface{
     /**
     * get card by querying in the database
     * @return card
     */
    @Override
    public Card getCardFromDB() {
        try {
            String sql = "SELECT * FROM Card";
            Statement stm = EcoBikeRental.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                String name = res.getString("owner");
                String securityCode = res.getString("cvvCode");
                String pin = res.getString("cardCode");
                String expiration = res.getString("dateExpired");
                Card card = new Card(securityCode, name, pin, expiration);
                return card;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * insert new card in to database
     * or find old card in the database
     * depend on the attribute of the param card
     * @param card
     * @return the id of the card in the database
     * @throws SQLException
     */
    @Override
    public int newCardDB(Card card) throws SQLException {
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

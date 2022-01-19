package domain.repository;

import java.sql.SQLException;

import domain.entity.transaction.Card;
import domain.entity.transaction.TransactionInfo;

public interface TransactionInfoRepositoryInterface {
    public void newTransactionDB(int ivID, Card card, TransactionInfo transactionInfo) throws SQLException;
}

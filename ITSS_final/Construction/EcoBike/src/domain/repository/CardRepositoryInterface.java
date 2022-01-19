package domain.repository;

import java.sql.SQLException;

import domain.entity.transaction.Card;

public interface CardRepositoryInterface {
    public Card getCardFromDB();
    public int newCardDB(Card card) throws SQLException;
}   

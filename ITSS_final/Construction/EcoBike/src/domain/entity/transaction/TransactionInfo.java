package domain.entity.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;

/**
 * This class is the transaction info entity
 * @author DungNM
 * @version 1.0
 */

public class TransactionInfo {
    private String errorCode;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    private Card card;
    private String transactionContent;
    private int amount;
    private String createdAt;
    
    /**
     * Constructor
     */
    public TransactionInfo() {
    }
    
    /**
     * Constructor
     * @param errorCode
     * @param card
     * @param transactionContent
     * @param amount
     * @param createdAt
     */
    public TransactionInfo(String errorCode, Card card, String transactionContent,
                           int amount, String createdAt) {
        this.errorCode = errorCode;
        this.card = card;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public TransactionInfo(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
    
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

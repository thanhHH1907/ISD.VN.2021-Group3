package domain.entity.transaction;


import common.utils.EcoBikeRental;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is the order entity
 * @author DungNM
 * @version 1.0
 */

public class Card {
    private String cvvCode;
    private String owner;
    private String cardCode;
    private String dateExpired;

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String name) {
        this.owner = name;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }


    public String getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(String expiration) {
        this.dateExpired = expiration;
    }


    /**
     * Constructor
     * @param cardCode
     * @param owner
     * @param cvvCode
     * @param dateExpired
     */
    public Card(String cardCode, String owner, String cvvCode, String dateExpired) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
    }

   

}

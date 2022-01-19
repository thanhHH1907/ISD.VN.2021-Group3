package domain.entity.invoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.entity.order.Order;
import common.utils.EcoBikeRental;

/**
 * This class is the invoice entity
 * @author DungNM
 * @version 1.0
 */
public class Invoice {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Order order;
    private int amount;
    private String contents;
    
    /**
     * Constructor
     * @param order
     * @param amount
     * @param contents
     */
    public Invoice(Order order, int amount, String contents) {
        this.order = order;
        this.amount = amount;
        this.contents = contents;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    
}

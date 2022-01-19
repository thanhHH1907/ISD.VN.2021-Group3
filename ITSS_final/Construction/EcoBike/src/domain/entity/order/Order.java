package domain.entity.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import domain.entity.bike.Bike;
import common.utils.EcoBikeRental;

/**
 * This class is the order entity
 * @author DungNM
 * @version 1.0
 */

public class Order  {
    protected int id;

    public int getId() {
        return this.id;
    }

    protected Bike rentedBike;
    protected LocalDateTime start;
    protected LocalDateTime end;
    protected int deposit;
    protected int totalUpToNow;

    public Bike getRentedBike() {
        return rentedBike;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getTotalUpToNow() {
        return totalUpToNow;
    }

    public void setRentedBike(Bike rentedBike) {
        this.rentedBike = rentedBike;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setTotalUpToNow(int totalUpToNow) {
        this.totalUpToNow = totalUpToNow;
    }
    
    /**
     * Constructor
     * use when start renting bike
     * @param rentedBike
     * @param start
     */
    public Order(Bike rentedBike, LocalDateTime start) {
        this.rentedBike = rentedBike;
        this.deposit = (int) (rentedBike.getValue() * 0.4);
        this.start = start;
        this.totalUpToNow = 15000;
    }
    
    /**
     * Constructor
     * use when returning bike
     * @param rentedBike
     * @param start
     * @param end
     * @param deposit
     * @param totalUpToNow
     */
    public Order(Bike rentedBike, LocalDateTime start, LocalDateTime end, int deposit, int totalUpToNow) {
        this.rentedBike = rentedBike;
        this.start = start;
        this.end = end;
        this.deposit = deposit;
        this.totalUpToNow = totalUpToNow;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

}


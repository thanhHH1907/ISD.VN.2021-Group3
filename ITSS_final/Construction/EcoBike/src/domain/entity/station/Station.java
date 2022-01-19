package domain.entity.station;
/**
 * This class is the station entity 
 * @author ThanhNG
 * @version 1.0
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.utils.EcoBikeRental;
import domain.entity.bike.Bike;


public class Station  {
    protected int id;
    protected String name;
    protected int numAvailableBike;
    protected double area;
    protected String address;
    private int numEmptyDockPoint;

    /**
     * Constructor
     * @param x
     */
    public Station(int x) {
        this.numEmptyDockPoint = x;
    }

    /**
     * Constructor
     * @param id
     * @param name
     * @param numAvailableBike
     * @param numEmptyDockPoint
     * @param area
     * @param address
     */
    public Station(int id,
                   String name,
                   int numAvailableBike,
                   int numEmptyDockPoint,
                   float area,
                   String address) {
        this.id = id;
        this.name = name;
        this.numAvailableBike = numAvailableBike;
        this.numEmptyDockPoint = numEmptyDockPoint;
        this.area = area;
        this.address = address;
    }

    public Station setId(int id) {
        this.id = id;
        return this;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    public Station setNumAvailableBike(int numAvailableBike) {
        this.numAvailableBike = numAvailableBike;
        return this;
    }

    public Station setAddress(String address) {
        this.address = address;
        return this;
    }

    public Station setArea(double area) {
        this.area = area;
        return this;
    }

    public Station setNumEmptyDockPoint(int numEmptyDockPoint) {
        this.numEmptyDockPoint = numEmptyDockPoint;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumAvailableBike() {
        return numAvailableBike;
    }

    public double getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public int getNumEmptyDockPoint() {
        return this.numEmptyDockPoint;
    }
    /**
     * Constructor
     * @throws SQLException
     */
    public Station() throws SQLException {
    }
    

}


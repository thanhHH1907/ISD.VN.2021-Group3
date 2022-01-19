package domain.entity.bike;
/**
 * This class is the base class for bike
 * @author BachDV
 * @version 1.0
 */

import java.sql.SQLException;
import domain.entity.station.Station;

public class Bike  {

    protected int id;
    protected String type;
    protected String licensePlate;
    protected boolean isRenting;
    protected int numPedal;
    protected int numSaddle;
    protected int numRearSeat;
    protected String barcode;
    protected int value;
    protected double coefficient;
    protected Station station;
    protected String urlImage;

    /**
     * Bike Constructor
     *
     * @throws SQLException
     */
    public Bike() throws SQLException {

    }

    /**
     * Bike Constructor
     *
     * @param id
     * @param licensePlate
     * @param barcode
     * @param type
     */
    public Bike(int id, String licensePlate, String barcode, String type) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.barcode = barcode;
        this.type = type;

    }

    /**
     * Bike Constructor
     *
     * @param id
     * @param type
     * @param licensePlate
     * @param value
     * @param numPedal
     * @param numSaddle
     * @param numRearSeat
     * @param barcode
     * @param isRenting
     * @param urlImage
     * @param coefficient
     */
    public Bike(int id, String type, String licensePlate, int value, int numPedal, int numSaddle, int numRearSeat, String barcode, boolean isRenting, String urlImage, int coefficient) {
        this.id = id;
        this.type = type;
        this.licensePlate = licensePlate;
        this.numPedal = numPedal;
        this.numSaddle = numSaddle;
        this.numRearSeat = numRearSeat;
        this.coefficient = coefficient;
        this.barcode = barcode;
        this.value = value;
        this.isRenting = isRenting;
        this.urlImage = urlImage;
    }

    /**
     * check if the bike is being rented or not
     *
     * @return isRenting
     */
    public boolean isRenting() {
        return isRenting;
    }

    public void setRenting(boolean renting) {
        isRenting = renting;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setNumPedal(int numPedal) {
        this.numPedal = numPedal;
    }

    public void setNumSaddle(int numSaddle) {
        this.numSaddle = numSaddle;
    }

    public void setNumRearSeat(int numRearSeat) {
        this.numRearSeat = numRearSeat;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getNumPedal() {
        return numPedal;
    }

    public int getNumSaddle() {
        return numSaddle;
    }

    public int getNumRearSeat() {
        return numRearSeat;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getValue() {
        return value;
    }

    public Station getStation() {
        return station;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public boolean getRenting() {
        return isRenting;
    }


    /**
     * Write a bike object to string
     *
     * @return string
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", barcode='" + barcode + "'" +
                ", value='" + value + "'" +
                ", type='" + type + "'" +
                ", urlImage='" + urlImage + "'" +
                "}";
    }

  
}

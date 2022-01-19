package domain.repository;

import java.sql.SQLException;

import domain.entity.bike.Bike;
import domain.entity.bike.StandardBike;

public interface BikeRepositoryInterface{
    public Bike getBikeById(int id, String type) throws SQLException ;
    public Bike getBikeByBarcode(String barcode) ;
    public int getRenting(int id) throws SQLException;
    public void updateBikeDB(int bikeID, int stationID) ;
    public void updateQtyDB(int isRent, Bike currentBike) throws SQLException;
}
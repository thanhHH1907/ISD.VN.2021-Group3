package data.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.entity.bike.Bike;
import domain.entity.station.Station;
import domain.repository.BikeRepositoryInterface;
import common.utils.EcoBikeRental;

public class BikeRepositoryImpl extends BaseRepository implements BikeRepositoryInterface{

    @Override
    public Bike getBikeById(int id,String type) throws SQLException {
        try {
            String sql;
            String qId = "\"" + id + "\"";
        
            if (type.equals("Standard electric bike")) {
                sql = "SELECT * FROM Bike B  natural join BikeDetail join  Station on B.stationID=Station.id join ElectricBike SEB on B.id=SEB.id where B.id= " + qId + ";";
            } else if (type.equals("Standard bike")) {
                sql = "SELECT * FROM Bike natural join BikeDetail join  Station on Bike.stationID=Station.id where type=\"Standard bike\" and Bike.id=" + qId + ";";
            } else if (type.equals("Twin bike")) {
                sql = "SELECT * FROM Bike natural join BikeDetail join  Station on Bike.stationID=Station.id  where type=\"Twin bike\" and Bike.id=" + qId + ";";
            } else if (type.equals("Electric twin bike")) {
                sql = "SELECT * FROM Bike B natural join BikeDetail join  Station on B.stationID=Station.id  join ElectricBike SEB on B.id=SEB.id    where type=\"Electric twin bike\" and  B.id=" + qId + ";";
            }else{
                sql = "SELECT * FROM Bike natural join BikeDetail join  Station on Bike.stationID=Station.id  where Bike.id=" + qId + ";";
            }
            Statement stm = EcoBikeRental.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                Bike bike = new Bike();
                return setValueBike(res, bike);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    /**
     * Set a bike from a result set by querying the db
     *
     * @param res
     * @param bike
     * @return Bike
     * @throws SQLException
     */
    public Bike setValueBike(ResultSet res, Bike bike) throws SQLException {
        bike.setLicensePlate(res.getString("licensePlate"));
        bike.setId(res.getInt("id"));
        bike.setNumRearSeat(res.getInt("numRearSeat"));
        bike.setLicensePlate(res.getString("licensePlate"));
        bike.setNumPedal(res.getInt("numPedal"));
        bike.setValue(res.getInt("value"));
        bike.setCoefficient(res.getInt("coefficientPrice"));
        bike.setUrlImage(res.getString("urlImage"));
        bike.setNumSaddle(res.getInt("numSaddle"));
        bike.setBarcode(res.getString("barcode"));
        bike.setRenting(res.getBoolean("isRenting"));
        bike.setType(res.getString("type"));
        Station station = new Station();
        station.setId(res.getInt("stationID"));
        station.setName(res.getString("name"));
        station.setNumEmptyDockPoint(res.getInt("numEmptyDockPoint"));
        station.setNumAvailableBike(res.getInt("numAvailableBike"));
        bike.setStation(station);
        return bike;
    }

    @Override
    public Bike getBikeByBarcode(String barcode) {
        try {
            barcode = "\"" + barcode + "\"";
            String sql = "SELECT * FROM Bike  join  Station on Bike.stationID=Station.id natural join BikeDetail where barcode= " + barcode + ";";
            Statement stm = EcoBikeRental.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                Bike bike = new Bike();
                return setValueBike(res, bike);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /**
     * check if a bike with an id is rented or not
     *
     * @param id
     * @return -1 if not found, 1 if rented, 0 otherwise
     * @throws SQLException
     */
    @Override
    public int getRenting(int id) throws SQLException {
        try {
            String qId = "\"" + id + "\"";
            String sql = "SELECT * FROM Bike  where Bike.id=" + qId + ";";
            Statement stm = EcoBikeRental.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                return res.getInt("isRenting");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }
    /**
     * Update the bike info in db after returning
     *
     * @param bikeID
     * @param stationID
     */
    @Override
    public void updateBikeDB(int bikeID, int stationID) {
        try {
            Statement stm = EcoBikeRental.getConnection().createStatement();
            String sql = " update " + "Bike" + " set" + " "
                    + " stationID " + "= " + stationID
                    + " where id = " + bikeID + " ;";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * update station and bike when a bike is returned/rented
     *
     * @param isRent
     * @param currentBike
     * @throws SQLException
     */
    @Override
    public void updateQtyDB(int isRent, Bike currentBike) throws SQLException {
        Station currentStation = currentBike.getStation();

        int stationID = currentStation.getId();
        int bikeID = currentBike.getId();

        int numAvailableBike = currentStation.getNumAvailableBike();
        int numEmptyDockPoint = currentStation.getNumEmptyDockPoint();

        if (isRent == 1) {
            numEmptyDockPoint++;
            numAvailableBike--;
        } else {
            numEmptyDockPoint--;
            numAvailableBike++;
        }
        updateFieldById("Station", stationID, "numEmptyDockPoint", Integer.toString(numEmptyDockPoint));
        updateFieldById("Station", stationID, "numAvailableBike", Integer.toString(numAvailableBike));
        updateFieldById("Bike", bikeID, "isRenting", Integer.toString(isRent));
    }

   


}
package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.utils.EcoBikeRental;
import domain.entity.bike.Bike;
import domain.entity.station.Station;
import domain.repository.StationRepositoryInterface;

public class StationRepositoryImpl extends BaseRepository implements StationRepositoryInterface {
    /**
     * Get all the bike of this station in database
     * @param stationId
     * @return List[Bike]
     * @throws SQLException
     */
    @Override
    public List<Bike> getAllBikeAvailable(int stationId) throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Bike where isRenting= 0 and stationId = " + stationId);
        ArrayList<Bike> medium = new ArrayList<>();
        while (res.next()) {
            Bike bike = new Bike();
            bike.setId(res.getInt("id"));
            bike.setType(res.getString("type"));
            bike.setLicensePlate(res.getString("licensePlate"));
            bike.setBarcode(res.getString("barCode"));
            bike.setUrlImage(res.getString("urlImage"));
            bike.setRenting(res.getBoolean("isRenting"));
            medium.add(bike);
        }
        return medium;
    }
    /**
     * Get all the station in the database
     * @return List[Station]
     * @throws SQLException
     */
    @Override
    public List<Station> getAllStations() throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Station");
        ArrayList<Station> medium = new ArrayList<>();
        while (res.next()) {
            Station station = new Station()
                    .setId(res.getInt("id"))
                    .setName(res.getString("name"))
                    .setNumEmptyDockPoint(res.getInt("numEmptyDockPoint"))
                    .setNumAvailableBike(res.getInt("numAvailableBike"))
                    .setArea(res.getDouble("area"))
                    .setAddress(res.getString("address"));
            medium.add(station);
        }
        return medium;
    }

     /**
     * get all the station with empty dock in database
     * @return List[Station]
     * @throws SQLException
     */
    @Override
    public List<Station> getStationHasEmptyDock() throws SQLException {
        List<Station> stations = getAllStations();

        for (Object s : stations) {
            if (((Station) s).getNumEmptyDockPoint() <= 0) {
                stations.remove(s);
            }
        }
        return stations;
    }
    
}

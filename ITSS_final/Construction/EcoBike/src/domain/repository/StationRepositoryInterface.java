package domain.repository;

import java.sql.SQLException;
import java.util.List;

import domain.entity.bike.Bike;
import domain.entity.station.Station;

public interface StationRepositoryInterface {
    public List<Bike> getAllBikeAvailable(int stationId) throws SQLException;
    public List<Station> getAllStations() throws SQLException;
    public List<Station> getStationHasEmptyDock() throws SQLException;
}

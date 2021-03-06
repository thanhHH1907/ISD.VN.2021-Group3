package presentation.controller;

import java.sql.SQLException;
import java.util.List;

import data.repository.StationRepositoryImpl;
import domain.entity.station.Station;
import domain.repository.StationRepositoryInterface;

/**
 * This class controls the flow of events in select dock to return bike screen
 * @author ThanhNG
 * @version 1.0
 *
 */
public class SelectDockToReturnBikeController extends BaseController{
	private StationRepositoryInterface stationRepository = new StationRepositoryImpl();
	/**
	 * Get all stations in DB that has empty dock to display
	 * @return List[Station]
	 * @throws SQLException
	 */
    public List getStationHasEmptyDock() throws SQLException {
        return stationRepository.getStationHasEmptyDock();
    }
}

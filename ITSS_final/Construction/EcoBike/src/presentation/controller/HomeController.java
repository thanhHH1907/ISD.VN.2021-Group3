package presentation.controller;

import java.sql.SQLException;
import java.util.List;

import data.repository.StationRepositoryImpl;
import domain.repository.StationRepositoryInterface;

/**
 * This class controls the flow of events in homescreen
 * @author ThanhNG
 * @version 1.0
 *
 */
public class HomeController extends BaseController {
	private StationRepositoryInterface stationRepository = new StationRepositoryImpl();
	/**
	 * Get all stations in DB to display in home screen
	 * @return List[Station]
	 * @throws SQLException
	 */
    public List getAllStations() throws SQLException {
        return stationRepository.getAllStations();
    }
}

package presentation.controller;

import java.sql.SQLException;
import java.util.List;

import data.repository.StationRepositoryImpl;
import domain.repository.StationRepositoryInterface;

public class ViewStationController extends BaseController {
	private StationRepositoryInterface stationRepository = new StationRepositoryImpl();
	/**
	 * Get all bikes in a station in DB to display in this screen
	 * @return List[Bike]
	 * @throws SQLException
	 */
    public List getAllBikeAvailable(int stationId) throws SQLException {
        return stationRepository.getAllBikeAvailable(stationId);
    }
}

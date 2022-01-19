package presentation.controller;

import common.exception.ViewBikeException;
import data.repository.BikeRepositoryImpl;
import domain.entity.bike.*;
import domain.repository.BikeRepositoryInterface;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * This class controls the flow of events in view bike screen
 * @author BachDV
 * @version 1.0
 *
 */
public class ViewBikeController extends BaseController {
	private BikeRepositoryInterface bikeRepository=new BikeRepositoryImpl();;
    /**
     * count 1 second
     * @param amount amount want to count
     * @return a hashmap include: hour, minute, second
     */
    public HashMap counting(int amount) {
        int hour = amount / 3600;
        int minute = (amount - hour * 3600) / 60;
        int second = amount - hour * 3600 - minute * 60;
        if (second < 59) second += 1;
        else {
            second = 0;
            if (minute < 59) minute += 1;
            else {
                hour += 1;
                minute = 0;
            }
        }
        HashMap<String, Integer> time = new HashMap<>();
        time.put("hour", hour);
        time.put("minute", minute);
        time.put("second", second);
        time.put("newAmount", amount + 1);
        return time;
    }

    /**
     * convert time in  localDateTime to second
     * @param start
     * @return seconds
     */
    public int calculateAmountMinutes(LocalDateTime start) {
        int hour = (int) ChronoUnit.HOURS.between(start, LocalDateTime.now());
        int minute = (int) ChronoUnit.MINUTES.between(start, LocalDateTime.now());
        int second = (int) ChronoUnit.SECONDS.between(start, LocalDateTime.now());
        return hour * 3600 + minute * 60 + second;
    }

    /**
     * create bike instance base on id and type
     * @param id
     * @param type
     * @return bike
     * @throws ViewBikeException
     */
    public Bike setBike(int id, String type) throws ViewBikeException {
        try {
            return  bikeRepository.getBikeById(id,type);
        } catch (ViewBikeException | SQLException e) {
            throw new ViewBikeException("Not found Bike");
        }
    }

    /**
     * check bike isRenting
     *
     * @param id of the bike we want to check
     * @return boolean
     */
    public boolean bikeIsRenting(int id) {
        try {
            return  bikeRepository.getRenting(id) == 1;
        } catch (SQLException e) {
            throw new ViewBikeException("Not found bikeID :" + id + "in DB");
        }
    }


}

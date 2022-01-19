package domain.entity.bike;


/**
 * This class is the base class for Standard Electric Bike
 * @author BachDV
 * @version 1.0
 */
import java.sql.SQLException;

public class StandardElectricBike extends Bike {
    /*
     * set default batteryPercentage=100%
     * set default remainingTime=14400= 4 hours
     */
    protected int batteryPercentage;
    protected int remainingTime;


    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    /**
     * Bike Constructor
     * @throws SQLException
     */
    public StandardElectricBike() throws SQLException { }

    



  


}

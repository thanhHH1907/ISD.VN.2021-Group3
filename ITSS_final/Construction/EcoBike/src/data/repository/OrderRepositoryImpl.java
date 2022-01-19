package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;
import domain.entity.order.Order;
import domain.repository.OrderRepositoryInterface;

public class OrderRepositoryImpl extends BaseRepository implements OrderRepositoryInterface {
    /**
     * write new order to Database
     * create order when start using rented bike
     * @throws SQLException
     */
    @Override
    public void newOrderDB(Order order) throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        String deposit = Integer.toString(order.getDeposit());
        String bikeID = Integer.toString(order.getRentedBike().getId());
        String start = order.getStart().toString();
        stm.execute("INSERT INTO EcoOrder(deposit, bikeID, startAt) VALUES (" + deposit + "," + bikeID + "," + "\'" + start + "\'" + ");");
        ResultSet res = stm.executeQuery("SELECT id from EcoOrder where endAt is NULL");

        int id = -1;
        //res.next();
        while (res.next())
            id = res.getInt("id");
        order.setId(id);
    }
    /**
     * write new order to Database
     * create order when start using rented bike
     * @throws SQLException
     */
    @Override
    public void updateOrderDB(Order order) throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        String end = order.getEnd().toString();
        String sql = " update " + "EcoOrder" + " set" + " "
                + "endAt" + "=" + "\'" + end + "\' "
                + ", amount =" + "\'" + order.getTotalUpToNow()+ "\' "
                + "where id =" + order.getId() + ";";
        stm.executeUpdate(sql);
    }
    
}

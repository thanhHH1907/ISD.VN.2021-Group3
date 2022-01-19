package domain.repository;

import java.sql.SQLException;

import domain.entity.order.Order;

public interface OrderRepositoryInterface{
    public void newOrderDB(Order order) throws SQLException;
    public void updateOrderDB(Order order) throws SQLException;
}
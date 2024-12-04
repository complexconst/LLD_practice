package FoodKart.dao.Impl;

import FoodKart.dao.OrderDao;
import FoodKart.entity.Order;
import FoodKart.exception.ItemNotFound;
import FoodKart.exception.NoOrderFoundException;

import java.util.HashMap;

public class OrderDaoImpl implements OrderDao {

    HashMap<Integer, Order> orders;


    public OrderDaoImpl(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    public Integer createOrder(Order order) {
        try {
            orders.put(order.getOrderId(), order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order.getOrderId();
    }



}
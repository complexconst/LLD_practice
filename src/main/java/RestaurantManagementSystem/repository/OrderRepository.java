package RestaurantManagementSystem.repository;

import RestaurantManagementSystem.entity.Order;

import java.util.HashMap;

public class OrderRepository {

    HashMap<Integer, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }

    void addOrder(Integer orderId, Order order) {
        orders.put(orderId, order);
    }

    Order getOrder(Integer orderId) {
        return orders.get(orderId);
    }

    void removeOrder(Integer orderId) {
        orders.remove(orderId);
    }

}

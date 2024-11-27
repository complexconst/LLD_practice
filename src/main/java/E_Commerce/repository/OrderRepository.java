package E_Commerce.repository;

import E_Commerce.entity.Order;

import java.util.HashMap;

public class OrderRepository implements IOrderRepository{

    HashMap<Integer, Order> orders;
    static int order_id = 1;

    public OrderRepository() {
        orders = new HashMap<>();
    }


    public Integer insertOrder(Order order) {
        orders.put(order_id++, order);
        return order_id - 1;
    }

    public Order getOrder(Integer orderId) {
        return orders.get(orderId);
    }
}

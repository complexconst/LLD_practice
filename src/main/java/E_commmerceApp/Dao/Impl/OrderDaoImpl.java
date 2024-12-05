package E_commmerceApp.Dao.Impl;

import E_commmerceApp.Dao.OrderDao;
import E_commmerceApp.Main;
import E_commmerceApp.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    Map<Integer, Order> orders;


    public OrderDaoImpl() {
        this.orders = new HashMap<>();
    }


    @Override
    public void addOrder(Order order) {
        orders.put(order.id(), order);
    }

    public Order getOrder(Integer orderId) {
        Order order = orders.get(orderId);
        return order;
    }
}

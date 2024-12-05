package E_commmerceApp.Dao;

import E_commmerceApp.entity.Order;

public interface OrderDao {

    void addOrder(Order order);

    public Order getOrder(Integer orderId);
}

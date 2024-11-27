package E_Commerce.repository;

import E_Commerce.entity.Order;

public interface IOrderRepository {
    public Integer insertOrder(Order order);

    public Order getOrder(Integer orderId);
}

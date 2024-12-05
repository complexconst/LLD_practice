package E_commmerceApp.service;

import E_commmerceApp.Dao.OrderDao;
import E_commmerceApp.Dao.ProductDao;
import E_commmerceApp.entity.Order;
import E_commmerceApp.entity.Product;

import java.util.List;

public class OrderService {

    ProductDao productDao;
    OrderDao orderDao;



    public OrderService(ProductDao productDao, OrderDao orderDao) {
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void createOrder(Integer orderId, List<Product> products) {
        try {
            Order order = new Order(orderId, products);
            List<Product> reqProducts = order.products();
            for(Product product : reqProducts) {
                productDao.placeOrder(product.id(), product.quantity());
            }
            orderDao.addOrder(order);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmOrder(Integer orderId) {
        Order order = orderDao.getOrder(orderId);
        for(Product product : order.products()) {
            productDao.confirmOrder(product.id(), product.quantity());
        }
    }

    public Integer getStock(Integer productId) {
        return productDao.getQuantity(productId);
    }
}

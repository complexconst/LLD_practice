package E_commmerceApp;

import E_commmerceApp.Dao.Impl.OrderDaoImpl;
import E_commmerceApp.Dao.Impl.ProductDaoImpl;
import E_commmerceApp.Dao.OrderDao;
import E_commmerceApp.Dao.ProductDao;
import E_commmerceApp.entity.Product;
import E_commmerceApp.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class E_commerce {

    OrderDao orderDao = new OrderDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    OrderService orderService = new OrderService(productDao, orderDao);



    void addProduct(Integer productId, Integer quantity) {
        Product product = new Product(productId, quantity);
        orderService.addProduct(product);
    }


    void createOrder(Integer orderId, List<Integer> productId, List<Integer> quantity) {
        List<Product> products = new ArrayList<>();
        for(int ind = 0; ind < productId.size(); ind++) {
            Product product = new Product(productId.get(ind), quantity.get(ind));
            products.add(product);
        }
        orderService.createOrder(orderId, products);
    }

    void confirmOrder(Integer orderId) {
        orderService.confirmOrder(orderId);
    }

    Integer getStock(Integer productId) {
        return orderService.getStock(productId);
    }
}

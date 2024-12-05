package E_commmerceApp.Dao.Impl;


import E_commmerceApp.Dao.ProductDao;
import E_commmerceApp.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    Map<Integer, Integer> stock;
    Map<Integer, Integer> stockOnHold;


    public ProductDaoImpl() {
        this.stock = new HashMap<>();
        this.stockOnHold = new HashMap<>();
    }


    public void addProduct(Product product) {
        stock.put(product.id(), product.quantity());
        stockOnHold.put(product.id(), 0);
    }

    public Integer getQuantity(Integer productId) {
        return stock.get(productId);
    }

    public void placeOrder(Integer productId, Integer quantity) {
        if(stock.get(productId) - stockOnHold.get(productId) >= quantity) {
            stockOnHold.put(productId, quantity);
        }
        else {
            throw new RuntimeException("Quantity not sufficient for productId : " + productId);
        }
    }

    public void confirmOrder(Integer productId, Integer quantity) {
        stock.put(productId, stock.get(productId) - quantity);
        stockOnHold.put(productId, quantity);
    }

}

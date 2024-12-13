package ecommeerce.dao.Impl;

import ecommeerce.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl {

    Map<Integer, Product> products = new HashMap<Integer, Product>();
    Map<Integer, Integer> stockOnHold = new HashMap<>();

    public void addProductInDb(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<Product>(products.values());
    }

    public void addStockOnHoldInDb(int id, Integer quantity) {
        var product
        products.put(id, );
        stockOnHold.put(id, quantity);
    }

    public Integer getStockQuantityOnHold(int id) {
        return stockOnHold.get(id);
    }

    public void confirmOrderInDb(int id, int quantity) {
        stockOnHold.remove(id);

    }

}

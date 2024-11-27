package E_Commerce.repository;

import E_Commerce.entity.Order;
import E_Commerce.entity.Product;

import java.util.HashMap;


public class ProductRepository implements IProductRepository{

    HashMap<Integer, Product> products;
    static int productId = 1;

    public ProductRepository() {
        products = new HashMap<>();
    }


    public Integer insertProduct(Product product) {
        products.put(productId++, product);
        return productId - 1;
    }

    public Product getProduct(Integer productId) {
        return products.get(productId);
    }
}
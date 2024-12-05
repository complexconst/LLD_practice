package E_commmerceApp.Dao;

import E_commmerceApp.entity.Product;

public interface ProductDao {

    public void addProduct(Product product);
    public Integer getQuantity(Integer productId);
    public void placeOrder(Integer productId, Integer quantity);
    public void confirmOrder(Integer productId, Integer quantity);
}

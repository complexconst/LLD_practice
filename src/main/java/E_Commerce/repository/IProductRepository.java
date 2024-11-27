package E_Commerce.repository;

import E_Commerce.entity.Product;

public interface IProductRepository {
    public Integer insertProduct(Product product);
    public Product getProduct(Integer productId);
}

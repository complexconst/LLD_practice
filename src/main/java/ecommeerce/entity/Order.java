package ecommeerce.entity;

import java.util.Map;

public class Order {
    private int order_id;
    private int customer_id;
    Map<Integer, Integer> productIdAndQuantity;

    public Order(int id, int customer_id, Map<Integer, Integer> productIdAndQuantity) {
        this.order_id = id;
        this.customer_id = customer_id;
        this.productIdAndQuantity = productIdAndQuantity;
    }



}

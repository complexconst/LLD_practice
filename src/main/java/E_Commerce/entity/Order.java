package E_Commerce.entity;

import E_Commerce.Enum.OrderStatus;


public class Order {
    private int order_id;
    private int user_id;
    private int product_id;
    private int quantity;
    private int total_price;
    OrderStatus status;

    public Order(int order_id, int user_id, int product_id, int quantity, int total_price, OrderStatus status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id(int user_id) {
        return user_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public int getProduct_id(int product_id) {
        return product_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getTotal_price() {
        return total_price;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

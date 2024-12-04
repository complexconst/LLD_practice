package FoodKart.entity;

import FoodKart.enums.OrderStatusType;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private int restaurantId;
    private OrderStatusType orderStatus;
    static int globOrderId = 0;
    private Integer billAmt = 0;
    private Map<String, Integer> itemAndQuantity;

    public Order(int restaurantId, OrderStatusType orderStatus, Integer billAmt, Map<String, Integer> itemAndQuantity) {
        this.restaurantId = restaurantId;
        this.orderStatus = orderStatus;
        this.billAmt = billAmt;
        orderId = globOrderId++;
        this.itemAndQuantity = itemAndQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getItemAndQuantity() {
        return itemAndQuantity;
    }
}

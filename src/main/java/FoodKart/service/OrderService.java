package FoodKart.service;

import FoodKart.dao.OrderDao;
import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Restaurant;
import FoodKart.enums.OrderStatusType;
import FoodKart.strategy.FindBestRestaurantStrategy;
import FoodKart.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    FindBestRestaurantStrategy findBestRestaurantStrategy;
    OrderDao orderDao;
    RestaurantService  restaurantService;


    public OrderService(FindBestRestaurantStrategy findBestRestaurantStrategy, OrderDao orderDao, RestaurantService restaurantService) {
        this.findBestRestaurantStrategy = findBestRestaurantStrategy;
        this.orderDao = orderDao;
        this.restaurantService = restaurantService;
    }

    public Integer placeOrder(HashMap<String, Integer> itemsQuantity) {
        Restaurant idealRestaurant = findBestRestaurantStrategy.findRestaurant(itemsQuantity);
        if(idealRestaurant == null) {
            return null;
        }
        Integer billAmt = 0;
        var menu = idealRestaurant.getMenu();
        Integer capacityReuirement = 0;
        for(Map.Entry<String, Integer> entry : itemsQuantity.entrySet()) {
            billAmt += entry.getValue() * menu.get(entry.getKey());
        }
        Order order = new Order(idealRestaurant.getId(), OrderStatusType.PREPARING, billAmt, itemsQuantity);
        restaurantService.addOrderForRestaurant(idealRestaurant.getId(), order);
        return orderDao.createOrder(order);
    }
}

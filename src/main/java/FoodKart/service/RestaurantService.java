package FoodKart.service;

import FoodKart.dao.Impl.RestaurantDaoImpl;
import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Order;
import FoodKart.entity.Restaurant;

import java.util.HashMap;

public class RestaurantService {

    RestaurantDao restaurantDao;


    public RestaurantService(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public Integer createRestaurant(int capacity, HashMap<String, Integer> menu) {
        Restaurant restaurant = new Restaurant(capacity, menu);
        return restaurantDao.createRestaurant(restaurant);
    }

    public void editMenu(Integer restaurantId, String itemName, Integer itemPrice) {
        restaurantDao.editMenu(restaurantId, itemName, itemPrice);
    }

    public Restaurant getBestRestaurant(String itemName, Integer quantity) {
        return restaurantDao.getBestRestaurantPriceForAnItem(itemName, quantity);
    }

    public void addOrderForRestaurant(Integer restaurantId, Order order) {
        restaurantDao.editCurCapacity(restaurantId, order);
    }
}

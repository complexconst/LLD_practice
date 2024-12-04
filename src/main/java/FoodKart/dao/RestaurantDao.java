package FoodKart.dao;

import FoodKart.entity.Order;
import FoodKart.entity.Restaurant;

public interface RestaurantDao {

    Integer createRestaurant(Restaurant restaurant);

    void editMenu(Integer restaurantId, String ItemName, Integer itemPrice) throws RuntimeException;

    public Restaurant getBestRestaurantPriceForAnItem(String item, Integer quantity) throws RuntimeException;

    public void editCurCapacity(Integer restaurantId, Order order) throws RuntimeException;
}

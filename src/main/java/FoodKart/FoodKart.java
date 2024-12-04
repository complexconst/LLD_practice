package FoodKart;

import FoodKart.dao.Impl.RestaurantDaoImpl;
import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Restaurant;
import FoodKart.service.RestaurantService;

import java.util.HashMap;
import java.util.Map;

public class FoodKart {
    // driver class
    HashMap<Integer, Restaurant> restaurants = new HashMap<>();
    RestaurantDao restaurantDao = new RestaurantDaoImpl(restaurants);
    RestaurantService restaurantService = new RestaurantService(restaurantDao);


    public FoodKart() {}


    void onboardRestaurant(int capacity, HashMap<String, Integer> menu) {
        restaurantService.createRestaurant(capacity, menu);
    }

    void editMenu(Integer restaurantId, HashMap<String, Integer> menu) {
        for(Map.Entry<String, Integer> entry : menu.entrySet()) {
            restaurantService.editMenu(restaurantId, entry.getKey(), entry.getValue());
        }
    }



}

package FoodKart.dao.Impl;

import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Order;
import FoodKart.entity.Restaurant;
import FoodKart.exception.ItemNotFound;
import FoodKart.exception.NoRestaurantFoundException;

import java.util.HashMap;
import java.util.Map;

public class RestaurantDaoImpl implements RestaurantDao {

    HashMap<Integer, Restaurant> restaurants;


    public RestaurantDaoImpl(HashMap<Integer, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Integer createRestaurant(Restaurant restaurant) {
        try {
            restaurants.put(restaurant.getId(), restaurant);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant.getId();
    }


    public void editMenu(Integer restaurantId, String ItemName, Integer itemPrice) throws RuntimeException {
        HashMap<String, Integer> menu;
        Restaurant restaurant = restaurants.get(restaurantId);
        if(restaurant == null) {
            throw new NoRestaurantFoundException("No Restaurant found with id " + restaurantId);
        }
        menu = restaurant.getMenu();

        if(!menu.containsKey(ItemName)) {
            throw new ItemNotFound("No Such Item found with name " + ItemName);
        }
        menu.put(ItemName, itemPrice);
        restaurants.put(restaurantId, restaurant);
    }

    public Restaurant getBestRestaurantPriceForAnItem(String item, Integer quantity) {
        Restaurant idealRestaurant = null;
        Integer minPriceForItem = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Restaurant> entry : restaurants.entrySet()) {
            Restaurant restaurant = entry.getValue();
            var menu = restaurant.getMenu();
            if(restaurant.getCurCapacity() + quantity <= restaurant.getCapacity()) {
                if(menu.containsKey(item) && menu.get(item) < minPriceForItem) {
                    minPriceForItem = menu.get(item);
                    idealRestaurant = restaurant;
                }
            }
        }
        if(idealRestaurant == null) {
            throw new NoRestaurantFoundException("No Restaurant found with item " + item);
        }
        return idealRestaurant;
    }


    @Override
    public void editCurCapacity(Integer restaurantId, Order order) throws RuntimeException {
        Restaurant restaurant = restaurants.get(restaurantId);

        var items = order.getItemAndQuantity();
        for(Map.Entry<Integer, Restaurant> entry : restaurants.entrySet()) {
            restaurant.setCurCapacity(restaurant.getCurCapacity() - items.get(entry.getKey()));
        }

        restaurants.put(restaurantId, restaurant);
    }
}

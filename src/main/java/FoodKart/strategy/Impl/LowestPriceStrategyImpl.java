package FoodKart.strategy.Impl;

import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Restaurant;
import FoodKart.exception.NoRestaurantFoundException;
import FoodKart.service.RestaurantService;
import FoodKart.strategy.FindBestRestaurantStrategy;

import java.util.HashMap;
import java.util.Map;

public class LowestPriceStrategyImpl implements FindBestRestaurantStrategy {

    RestaurantService restaurantService;

    public LowestPriceStrategyImpl(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public Restaurant findRestaurant(HashMap<String, Integer> itemsQuantity) {
        try {
            Restaurant idealRestaurant = null;
            for(Map.Entry<String, Integer> entry : itemsQuantity.entrySet()) {
                Restaurant restaurant = restaurantService.getBestRestaurant(entry.getKey(), entry.getValue());
                if(restaurant == null) {
                    throw new NoRestaurantFoundException("No restaurant found for item " + entry.getKey());
                }
                else {
                    Boolean isValidRestaurant = true;
                    for (Map.Entry<String, Integer> item: itemsQuantity.entrySet()) {
                        var menu = restaurant.getMenu();
                        if(menu.containsKey(item.getKey()) && menu.get(item.getKey()).compareTo(item.getValue()) > 0) {
                            continue;
                        }
                        isValidRestaurant = false;
                    }
                    if(isValidRestaurant) {
                        idealRestaurant = restaurant;
                    }
                }
                if(idealRestaurant != null) {
                    break;
                }
            }
            if(idealRestaurant == null) {
                throw new NoRestaurantFoundException("No restaurant found for item " + itemsQuantity.keySet() + " because no restaurant satisifies order in total");
            }
            return idealRestaurant;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

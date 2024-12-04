package FoodKart.strategy;

import FoodKart.dao.Impl.RestaurantDaoImpl;
import FoodKart.dao.RestaurantDao;
import FoodKart.entity.Restaurant;

import java.util.HashMap;

public interface FindBestRestaurantStrategy {


    Restaurant findRestaurant(HashMap<String, Integer> itemsQuantity);
}

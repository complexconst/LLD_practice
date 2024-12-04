package FoodKart.entity;

import java.util.HashMap;
import java.util.List;

public class Restaurant {
    static int globRestaurantId;
    private int id;
    int capacity;
    int curCapacity;

    // Menu --> item, price
    HashMap<String, Integer> menu;

    // items served --> item, quantity
    HashMap<String, Integer> itemsServed;



    public Restaurant(int capacity, HashMap<String, Integer> menu) {
        this.id = globRestaurantId++;
        this.capacity = capacity;
        this.curCapacity = 0;
        this.menu = menu;
        this.itemsServed = new HashMap<>();
    }


    public int getCurCapacity() {
        return curCapacity;
    }
    public void setCurCapacity(int curCapacity) {
        this.curCapacity = curCapacity;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Integer> getMenu() {
        return menu;
    }
}

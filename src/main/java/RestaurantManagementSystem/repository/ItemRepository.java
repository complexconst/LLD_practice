package RestaurantManagementSystem.repository;

import RestaurantManagementSystem.entity.Item;

import java.util.HashMap;

public class ItemRepository {

    HashMap<Integer, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
    }

    public void addItem(Integer itemId, Item item) {
        items.put(itemId, item);
    }

    public Item getItem(Integer itemId) {
        return items.get(itemId);
    }

    public void removeItem(Integer itemId) {
        items.remove(itemId);
    }

    public void showAllItems() {
        System.out.println(items);
    }

}

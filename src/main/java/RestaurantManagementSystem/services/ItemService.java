package RestaurantManagementSystem.services;

import RestaurantManagementSystem.entity.Item;
import RestaurantManagementSystem.repository.ItemRepository;

public class ItemService {

    ItemRepository itemRepository;
    static int globItemId = 0;

    public ItemService() {
        this.itemRepository = new ItemRepository();
    }


    public void showaAllItems(){
        itemRepository.showAllItems();
    }

    public void addItem(Item item){
        globItemId++;
        itemRepository.addItem(globItemId, item);
    }

    public void removeItem(Integer itemId){
        itemRepository.removeItem(itemId);
    }
}

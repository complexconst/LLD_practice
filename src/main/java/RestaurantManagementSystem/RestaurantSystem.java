package RestaurantManagementSystem;

import RestaurantManagementSystem.entity.Item;
import RestaurantManagementSystem.services.*;

public class RestaurantSystem {

    BookingService bookingService = new BookingService();
    CustomerService customerService = new CustomerService();
    ItemService itemService = new ItemService();
    PaymentService paymentService = new PaymentService();
    TableService tableService = new TableService();


    void addItems() {
        Item item = new Item(1, "Dal","very tasty", 200);
        itemService.addItem(item);
    }

    void showMenu() {
        itemService.showaAllItems();
    }
    void reserveTable(Integer customerId, Integer tableId) {
//        bookingService.makeBooking();
    }

    void cancelReservation() {}

    void attendCustomer() {}


    void takeOrder() {}


    void generateBill() {}

    void takePayment() {}


}

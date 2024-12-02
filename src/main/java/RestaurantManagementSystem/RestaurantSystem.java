package RestaurantManagementSystem;

import RestaurantManagementSystem.entity.Item;
import RestaurantManagementSystem.enums.TableType;
import RestaurantManagementSystem.repository.*;
import RestaurantManagementSystem.services.*;

import java.time.LocalDateTime;

import static RestaurantManagementSystem.enums.PaymentType.CARD;
import static RestaurantManagementSystem.enums.PaymentType.CASH;
import static RestaurantManagementSystem.enums.TableType.MEDIUM;

public class RestaurantSystem {

    BookingRepository bookingRepository = new BookingRepository();
    CustomerRepository customerRepository = new CustomerRepository();
    ItemRepository itemRepository = new ItemRepository();
    OrderRepository orderRepository = new OrderRepository();
    TableRepository tableRepository = new TableRepository();
    CustomerService customerService = new CustomerService();
    ItemService itemService = new ItemService();
    CardService paymentService = new CardService();
    TableService tableService = new TableService(tableRepository);
    PaymentFactory paymentFactory = new PaymentFactory();
    BookingService bookingService = new BookingService(paymentFactory, tableService, bookingRepository);


    void addTable() {

    }

    void addItems() {
        Item item = new Item(1, "Dal","very tasty", 200);
        itemService.addItem(item);
    }

    void showMenu() {
        itemService.showaAllItems();
    }
    void reserveTable() {
        bookingService.makeBooking(CASH, 1, MEDIUM, LocalDateTime.now(), LocalDateTime.now());
    }

    void showBooking() {
        bookingService.showAllBookings();
    }

    void cancelReservation() {}

    void attendCustomer() {}


    void takeOrder() {}


    void generateBill() {}

    void takePayment() {}


}

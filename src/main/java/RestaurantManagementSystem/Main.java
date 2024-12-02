package RestaurantManagementSystem;

public class Main {
    public static void main(String[] args) {
        RestaurantSystem restaurantSystem = new RestaurantSystem();

        restaurantSystem.addItems();
        restaurantSystem.showMenu();

        restaurantSystem.tableService.addTable(2);

        restaurantSystem.tableService.addTable(3);
        restaurantSystem.tableService.addTable(4);
        restaurantSystem.tableService.addTable(5);
        restaurantSystem.reserveTable();
        restaurantSystem.showBooking();

    }
}

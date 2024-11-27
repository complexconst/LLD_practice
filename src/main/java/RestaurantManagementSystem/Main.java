package RestaurantManagementSystem;

public class Main {
    public static void main(String[] args) {
        RestaurantSystem restaurantSystem = new RestaurantSystem();

        restaurantSystem.addItems();
        restaurantSystem.showMenu();
    }
}

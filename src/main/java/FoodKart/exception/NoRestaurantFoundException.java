package FoodKart.exception;

public class NoRestaurantFoundException extends RuntimeException{
    public NoRestaurantFoundException(String message) {
        super(message);
    }
}

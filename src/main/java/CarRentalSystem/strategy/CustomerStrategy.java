package CarRentalSystem.strategy;

import CarRentalSystem.entity.Car;
import CarRentalSystem.entity.CarReceipt;

import java.util.List;

public interface CustomerStrategy {
    List<Car> searchCar(String model, Integer capacity);
}

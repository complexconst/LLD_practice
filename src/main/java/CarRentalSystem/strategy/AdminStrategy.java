package CarRentalSystem.strategy;

import CarRentalSystem.entity.Car;

public interface AdminStrategy {
    void addCar(Car car);
    void removeCar(Integer carId);
    void modifyCar(Integer carId);
}

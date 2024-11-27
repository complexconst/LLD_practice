package CarRentalSystem.repository;

import CarRentalSystem.entity.Car;

public interface CarRepository {
    Integer addCar(Car car);
    void removeCar(Integer carId);
    Car getCarById(Integer carId);
}

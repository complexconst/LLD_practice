package CarRentalSystem.repository;

import CarRentalSystem.entity.Car;

import java.util.HashMap;

public class CarRepositoryImpl implements CarRepository {
    HashMap<Integer, Car> cars;
    static int id = 1;

    public CarRepositoryImpl() {
        cars = new HashMap<>();
    }

    public Integer addCar(Car car) {
        cars.put(id++, car);
        return id - 1;
    }

    public void removeCar(Integer id) {
        cars.remove(id);
    }

    public Car getCarById(Integer id) {
        return cars.get(id);
    }
}

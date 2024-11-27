package CarRentalSystem.repository;

import CarRentalSystem.entity.Car;

import java.util.HashMap;
import java.util.List;

public class CarSearchRepositoryImpl implements CarSearchRepository {
    HashMap<String, HashMap<Integer, List<Integer>>> carSearch;

    public CarSearchRepositoryImpl() {
        carSearch = new HashMap<>();
    }

    public List<Integer> searchCar(String model, Integer capacity) {
        var availablemodelCars = carSearch.get(model);
        if (availablemodelCars == null) {
            return null;
        }
        return availablemodelCars.get(capacity);
    }

    public void removeCar(String model, Integer carId) {
        try {
            carSearch.get(model).remove(carId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

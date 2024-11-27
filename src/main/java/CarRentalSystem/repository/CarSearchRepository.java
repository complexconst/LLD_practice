package CarRentalSystem.repository;

import java.util.List;

public interface CarSearchRepository {
    List<Integer> searchCar(String model, Integer capacity);
    void removeCar(String model, Integer capacity);
}

package CarRentalSystem.strategy;

import CarRentalSystem.entity.Car;
import CarRentalSystem.entity.CarReceipt;
import CarRentalSystem.repository.CarRepository;
import CarRentalSystem.repository.CarRepositoryImpl;
import CarRentalSystem.repository.CarSearchRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerStrategyImpl implements CustomerStrategy {
    CarRepository carRepository;
    CarSearchRepository carSearchRepository;
    static Integer ticketId = 1;

    CustomerStrategyImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> searchCar(String model, Integer capacity) {
        List<Integer> carIds = carSearchRepository.searchCar(model, capacity);
        List<Car> cars = new ArrayList<>();
        for(Integer carId : carIds) {
            Car car = carRepository.getCarById(carId);
            if(car != null) {
                cars.add(car);
            }
        }
        return cars;
    }

    public CarReceipt makeBooking(Integer carId) {
        if(carRepository.getCarById(carId) != null) {
            Car car = carRepository.getCarById(carId);
            carSearchRepository.removeCar(car.model, car.capacity);
            CarReceipt receipt = new CarReceipt(carId, LocalDateTime.now());
            return receipt;
        }
        else {
            System.out.println("No cars found !!");
            return null;
        }
    }

}

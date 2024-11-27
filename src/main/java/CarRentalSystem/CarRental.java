package CarRentalSystem;

import CarRentalSystem.strategy.AdminStrategy;
import CarRentalSystem.strategy.CustomerStrategy;

public class CarRental {
    CustomerStrategy customerStrategy;
    AdminStrategy adminStrategy;

    CarRental(CustomerStrategy customerStrategy, AdminStrategy adminStrategy) {
        this.customerStrategy = customerStrategy;
        this.adminStrategy = adminStrategy;
    }

    void searchCar(String model, Integer capacity) {
        var list = customerStrategy.searchCar(model, capacity);
        list.forEach(System.out::println);
    }


}

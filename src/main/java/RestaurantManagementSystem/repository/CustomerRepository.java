package RestaurantManagementSystem.repository;

import RestaurantManagementSystem.entity.Customer;

import java.util.HashMap;

public class CustomerRepository {

    HashMap<Integer, Customer> customers;

    public CustomerRepository() {
        customers = new HashMap<>();
    }

    void addCustomer(Integer customerId, Customer customer) {
        customers.put(customerId, customer);
    }
    Customer getCustomer(Integer customerId) {
        return customers.get(customerId);
    }
    void removeCustomer(Integer customerId) {
        customers.remove(customerId);
    }

}

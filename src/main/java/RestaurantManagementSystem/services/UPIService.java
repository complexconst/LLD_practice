package RestaurantManagementSystem.services;

public class UPIService implements IPaymentService{

    @Override
    public void acceptPayment() {
        System.out.println("UPI accepted");
    }
}

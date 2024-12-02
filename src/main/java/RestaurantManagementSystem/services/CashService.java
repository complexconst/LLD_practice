package RestaurantManagementSystem.services;

public class CashService implements IPaymentService{

    @Override
    public void acceptPayment() {
        System.out.println("Payment accepted by cash service");
    }
}

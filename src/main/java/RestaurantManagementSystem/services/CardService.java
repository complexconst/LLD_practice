package RestaurantManagementSystem.services;

public class CardService implements IPaymentService{


    @Override
    public void acceptPayment(){
        System.out.println("Card accepted");
    }
}

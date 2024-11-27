package E_Commerce.service;

import E_Commerce.Enum.PaymentType;

public class CardPayment implements IPaymentService{



    @Override
    public void acceptPayment() {
        System.out.println("Card accepted");
    }



}

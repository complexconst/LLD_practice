package E_Commerce.service;

import E_Commerce.Enum.PaymentType;

public class CashPayment implements IPaymentService{

    @Override
    public void acceptPayment() {
        System.out.println("Cash accepted");
    }



}
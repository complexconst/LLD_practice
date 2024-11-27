package E_Commerce.service;

import E_Commerce.Enum.PaymentType;

import java.util.HashMap;

public class PaymentFactory {

    public IPaymentService getPaymentService(PaymentType paymentType) {
        switch (paymentType) {
            case PaymentType.CARD:
                return new CardPayment();


            case PaymentType.CASH:
                return new CashPayment();

                default:
                    return null;
        }
    }

}

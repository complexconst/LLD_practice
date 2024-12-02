package RestaurantManagementSystem.services;

import RestaurantManagementSystem.enums.PaymentType;

public class PaymentFactory {


    public IPaymentService getPaymentService(PaymentType paymentType) {
        switch (paymentType) {
            case UPI :
                return new UPIService();

            case CARD:
                return new CardService();

            case CASH:
                return new CashService();
        }
        return null;
    }
}

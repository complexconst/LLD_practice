package E_Commerce;

import E_Commerce.Enum.PaymentType;
import E_Commerce.entity.PaymentDetails;
import E_Commerce.entity.User;
import E_Commerce.service.IOrderService;
import E_Commerce.service.IUserService;
import E_Commerce.service.PaymentFactory;

import java.util.HashMap;

public class ECommerce {

    IUserService userService;
    IOrderService orderService;
    PaymentFactory paymentFactory;

    public ECommerce(IUserService userService, IOrderService orderService, PaymentFactory paymentFactory) {
        this.userService = userService;
        this.orderService = orderService;
        this.paymentFactory = paymentFactory;
    }

    public Integer createUser(String name, String phone, String email) {
        User newUser = new User(name, email, phone);
        return userService.addUser(newUser);
    }
    public void searchItem() {

    }


    public Integer placeOrder(Integer orderId, PaymentType paymentType) {
        var paymentMethod = paymentFactory.getPaymentService(paymentType);

        paymentMethod.acceptPayment();

        return orderId;
    }

    public void cancelOrder() {

    }



}

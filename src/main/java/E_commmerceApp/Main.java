package E_commmerceApp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        E_commerce app = new E_commerce();

        app.addProduct(1, 3);

        app.addProduct(2, 4);

        app.addProduct(3, 5);

        app.addProduct(4, 6);


        List<Integer> productId = new ArrayList<Integer>();
        productId.add(1);
        productId.add(2);

        List<Integer> quantity = new ArrayList<Integer>();
        quantity.add(2);
        quantity.add(2);

        app.createOrder(123, productId, quantity);

        System.out.println(app.getStock(1));

        app.createOrder(124, productId, quantity);

        app.confirmOrder(123);

        System.out.println(app.getStock(1));
    }
}

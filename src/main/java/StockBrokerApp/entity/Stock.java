package StockBrokerApp.entity;

import java.util.ArrayList;
import java.util.List;

public class Stock implements ISubject {
    private int id;
    private String stockName;
    Integer stockQuantity;
    Integer stockPrice;
    List<IObserver> observers = new ArrayList<>();


    public Stock(Integer id, String stockName, Integer stockQuantity, Integer stockPrice) {
        this.id = id;
        this.stockName = stockName;
        this.stockQuantity = stockQuantity;
        this.stockPrice = stockPrice;
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
     public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }
}

package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherMeasurer {

    List<IObserver> observers;
    private Integer temperature;
    private Integer humidity;


    public WeatherMeasurer() {
        observers = new ArrayList<IObserver>();
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }


    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setState(Integer temperature, Integer humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

package ObserverPattern;

import java.util.List;

public interface IWeatherMeasurer {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

package ObserverPattern;

public class Observer implements IObserver {
    IWeatherMeasurer measurer;
    @Override
    public void update() {
        System.out.println("Observer update");
    }
}

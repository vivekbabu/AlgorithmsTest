package in.designpatterns.scala.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temp, float hum, float press) {
        this.temperature = temp;
        this.humidity = hum;
        this.pressure = press;
        notifyObservers();
    }
}

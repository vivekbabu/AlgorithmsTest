package in.designpatterns.scala.observer;

public class ChangeDisplayElement implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final Observable weatherData;

    public ChangeDisplayElement(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
    }

    @Override
    public void display() {}

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
}

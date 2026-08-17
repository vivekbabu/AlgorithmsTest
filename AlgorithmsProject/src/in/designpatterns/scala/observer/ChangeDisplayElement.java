package in.designpatterns.scala.observer;

public class ChangeDisplayElement implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    public ChangeDisplayElement(Observable weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float hum, float press) {
        this.temperature = temp;
        this.humidity = hum;
        this.pressure = press;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + " % humidity");
    }

    public float temperature() { return temperature; }
    public float humidity() { return humidity; }
    public float pressure() { return pressure; }
}

package in.designpatterns.scala.observer;

public class MainClass {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        ChangeDisplayElement display = new ChangeDisplayElement(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}

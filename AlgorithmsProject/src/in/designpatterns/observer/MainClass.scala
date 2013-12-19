package in.designpatterns.observer

object MainClass {
  def main(args: Array[String]) {
    val weatherData = new WeatherData
    val changeDisplayElement = new ChangeDisplayElement(weatherData)
    weatherData.setMeasurements(100, 20, 100)
  }
}
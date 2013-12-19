package in.designpatterns.observer

class ChangeDisplayElement(observable: Observable) extends DisplayElement with Observer {
  var temperature: Float = _
  var humidity: Float = _
  var pressure: Float = _
  observable.addObserver(this)

  override def display =
    println("Current conditions: " + temperature
      + "F degrees and " + humidity + " % humidity");

  override def update(observable: Observable, objectPushed: Any) = {
    var weatherData: WeatherData = null
    weatherData = observable match {
      case n: WeatherData => observable.asInstanceOf[WeatherData]
    }
    if (weatherData != null) {
      temperature = weatherData.temperature
      humidity = weatherData.humidity
      pressure = weatherData.pressure
      display
    }
  }
}
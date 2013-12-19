package in.designpatterns.observer

class WeatherData extends Observable {
  var temperature: Float = _
  var humidity: Float = _
  var pressure: Float = _

  def setMeasurements(temp: Float, hum: Float, press: Float) = {
    this.temperature = temp
    this.humidity = hum
    this.pressure = press
    measurementsChanged
  }

  def measurementsChanged = {
    setChanged
    notifyObservers
  }
}
package in.designpatterns.observer

trait DisplayElement {
  def display(): Unit = { println("Default display is run here") }
}
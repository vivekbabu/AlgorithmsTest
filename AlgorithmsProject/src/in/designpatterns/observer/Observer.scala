package in.designpatterns.observer

trait Observer {
  def update(observable: Observable, objectPushed: Any): Unit = { println("Default update method ran") }
}
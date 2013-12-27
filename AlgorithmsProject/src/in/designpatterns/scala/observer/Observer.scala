package in.designpatterns.scala.observer

trait Observer {
  def update(observable: Observable, objectPushed: Any) =  println("Default update method ran") 
}
package in.designpatterns.scala.observer

trait Observable {
  var changed: Boolean = false
  var observers = Set.empty[Observer]
  def setChanged(): Unit = { this.changed = true }
  def notifyObservers(): Unit = { observers.foreach { observer => observer.update(this, null) }; changed = false }
  def notifyObservers(o: Any): Unit = { observers.foreach { observer => observer.update(this, o) }; changed = false }
  def addObserver(observer: Observer): Unit = { observers += observer; }
  def deleteObserver(observer: Observer): Unit = { observers -= observer }
}
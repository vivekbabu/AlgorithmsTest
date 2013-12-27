package in.designpatterns.scala.singleton

object Singleton {

  var singleton: Singleton = _
  var totalTimesCalled = 0
  def getInstance(): Singleton = {
    this
  }

  def incrementcalls() = totalTimesCalled = totalTimesCalled + 1

  def printCalls() = println("Total Calls :" + totalTimesCalled)

}


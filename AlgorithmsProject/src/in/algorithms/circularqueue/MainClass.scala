package in.algorithms.circularqueue

object MainClass {
  def main(args: Array[String]) {
    var circularQueue = new CircularQueue(5)
    for (i <- 1 to 6)
      circularQueue.enqueue(i)
    circularQueue.display

  }
}
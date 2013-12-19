package in.algorithms.circularqueue

class CircularQueue(size: Int) {
  var queue = Array.ofDim[Int](size)
  var head = -1
  var rear = -1

  def enqueue(element: Int) = {
    if ((head == 0 && rear == size - 1) || rear == head - 1)
      println(" Cannot insert " + element + ".Queue is full")
    else {
      if (rear == size - 1)
        rear = 0
      else
        rear = rear + 1
      queue(rear) = element
      if (head == -1)
        head = 0
      println(element + " inserted")
    }
  }

  def dequeue() = {
    if (head == -1)
      println("Queue is empty")
    else {
      println(queue(head) + " is deleted")
      if (head == rear) {
        head = -1
        rear = -1
      }

      if (head == size - 1)
        head = 0
      else
        head = head + 1
    }

  }

  def display() = {
    if (rear == -1) {
      println("Queue is empty")
    } else {
      println("The elements are")
      if (head <= rear) {
        for (i <- head to rear) {
          print(queue(i) + "->")
        }
      } else {
        for (i <- head to size - 1) {
          print(queue(i) + "->")
        }
        for (i <- 0 to rear) {
          print(queue(i) + "->")
        }

      }
    }

  }

}
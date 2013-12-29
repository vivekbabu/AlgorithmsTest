package in.algorithms.sort

object InsertionSort {
  def insertionSort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => List(x)
      case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
    }
  }
  def main(args: Array[String]) {
    println(insertionSort(List(2, 1, 3, 6, 5, 4)))
  }

}
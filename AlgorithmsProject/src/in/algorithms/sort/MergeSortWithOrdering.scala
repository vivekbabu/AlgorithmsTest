package in.algorithms.sort

object MergeSortWithOrdering {
  def mergesort[T](xs: List[T])(lt: Ordering[T]): List[T] = {

    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) => if (lt.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }

      }
      val (fst, sec) = xs splitAt (n)
      merge(mergesort(fst)(lt), mergesort(sec)(lt))
    }

  }
  def main(args: Array[String]) {
    println(mergesort(List(2, 1, 3, 6, 5, 4))(Ordering.Int))
    println(mergesort(List("mangoes", "oranges", "apples", "lemons"))(Ordering.String))
  }
}
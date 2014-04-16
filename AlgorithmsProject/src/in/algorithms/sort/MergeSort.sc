package in.algorithms.sort

object MergeSort {
  def mergeSort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }
      }
      val (fs, sec) = xs splitAt (n)
      merge(mergeSort(fs)(lt), mergeSort(sec)(lt))
    }

  }                                               //> mergeSort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  mergeSort(List(2, 1, 3, 6, 5, 4))((x, y) => x < y)
                                                  //> res0: List[Int] = List(1, 2, 3, 4, 5, 6)
}
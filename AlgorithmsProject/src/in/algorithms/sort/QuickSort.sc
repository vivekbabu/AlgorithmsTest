package in.algorithms.sort

object QuickSort {
  println("hello")                                //> hello
  def quicksort(xs: List[Integer]): List[Integer] = {
    if (xs.length < 2) xs
    else {
      val pivot = xs(xs.length / 2)
      quicksort(xs.filter(pivot > _)) ++ xs.filter(pivot == _) ++ quicksort(xs.filter(pivot < _))
    }
  }                                               //> quicksort: (xs: List[Integer])List[Integer]
  quicksort(List(2, 1, 3, 6, 5, 4))               //> res0: List[Integer] = List(1, 2, 3, 4, 5, 6)
}
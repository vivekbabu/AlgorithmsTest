package in.pairwithsumx

object PairWithSumX {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def pairWithSumX(xs: List[Int], sum: Int): List[(Int, Int)] = {
    var pairs: List[(Int, Int)] = List()
    def quickSort(xs: List[Int]): List[Int] = {
      val middle = xs.length / 2
      if (middle < 1) xs
      else {
        val pivot = xs(middle)
        quickSort(xs.filter(x => x < pivot)) ++ xs.filter(x => x == pivot) ++ quickSort(xs.filter(x => x > pivot))
      }
    }
    val sortedList = quickSort(xs)
    var i = 0
    var j = sortedList.length - 1
    while (i < j) {
      if (sortedList(i) + sortedList(j) == sum) {
        pairs = (sortedList(i), sortedList(j)) :: pairs
        i += 1
        j -= 1
      } else if (sortedList(i) + sortedList(j) < sum) i += 1
      else if (sortedList(i) + sortedList(j) > sum) j -= 1
    }
    pairs
  }                                               //> pairWithSumX: (xs: List[Int], sum: Int)List[(Int, Int)]
  pairWithSumX(List(2, 1, 5, 3, 4, -10, 16), 6)   //> res0: List[(Int, Int)] = List((2,4), (1,5), (-10,16))
}
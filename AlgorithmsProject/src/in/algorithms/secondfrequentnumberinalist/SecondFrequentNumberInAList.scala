package in.algorithms.secondfrequentnumberinalist

object SecondFrequentNumberInAList {
  def main(args: Array[String]) {
    println(secondFrequentNumberInAList(List(2, 3, 4, 5, 1, 1, 1, 2, 3, 3, 2, 1, 3, 3, 3, 2, 2, 1, 1, 1, 3, 3, 3, 2)))

  }
  def secondFrequentNumberInAList(list: List[Int]): (Int, Int) = {
    def quickSort(list: List[Int]): List[Int] = {
      val middle = list.size / 2
      if (middle < 1) list
      else {
        val pivot = list(middle)
        quickSort(list.filter(_ < pivot)) ++ list.filter(_ == pivot) ++ quickSort(list.filter(_ > pivot))
      }
    }

    val sortedList = quickSort(list)
    println(sortedList)
    var localMaxima = (sortedList(0), 1)
    var max = (sortedList(0), 1)
    var second = (sortedList(0), 1)
    def upadateMaxs = {
      if (localMaxima._2 > max._2) {
        second = max
        max = localMaxima
      } else if (localMaxima._2 > second._2) {
        second = localMaxima
      }
    }
    for (i <- 1 to sortedList.length - 1) {
      if (sortedList(i) == sortedList(i - 1)) {
        localMaxima = (localMaxima._1, localMaxima._2 + 1)
      } else {
        upadateMaxs
        localMaxima = (sortedList(i), 1)
      }
    }
    upadateMaxs
    second
  }

}
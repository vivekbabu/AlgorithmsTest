package in.algorithms.combination

object TripletsWithSumZero {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val list = List(1, -2, -3, 4, -5, 6, -7, 8)     //> list  : List[Int] = List(1, -2, -3, 4, -5, 6, -7, 8)
  def combinations(origList: List[Int]): List[List[Int]] = {

    def comb(list: List[Int], acc: List[List[Int]]): List[List[Int]] = list match {
      case Nil => acc
      case x :: xs => comb(xs, acc ::: acc.filter(_.length <= 2).map(x :: _))
    }

    val combs = comb(origList, List(List()))
    combs.filter(_.sum == 0).map(_.sortWith((a, b) => origList.indexOf(a) < origList.indexOf(b)))
  }                                               //> combinations: (origList: List[Int])List[List[Int]]

  combinations(list)                              //> res0: List[List[Int]] = List(List(), List(1, 4, -5), List(1, 6, -7), List(-3
                                                  //| , -5, 8))

}
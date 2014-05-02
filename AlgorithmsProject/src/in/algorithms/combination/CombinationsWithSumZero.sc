package in.designpatterns.scala.singleton

object CombinationsWithSumZero {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val list = List(1, -2, -3, 4,-5,6,-7,8)         //> list  : List[Int] = List(1, -2, -3, 4, -5, 6, -7, 8)
  var closestsum = 0                              //> closestsum  : Int = 0
  def combination(list: List[Int]): List[List[Int]] = {

    def combine(list: List[Int], acc: List[List[Int]]): List[List[Int]] = list match {
      case Nil => acc
      case x :: xs => combine(xs, acc ::: acc.map(x :: _)).filter(a => a.sum == 0).map(_.sortWith((a, b) => a < b)).sortWith((a, b) => a.length < b.length)
    }
    combine(list, List(List()))
  }                                               //> combination: (list: List[Int])List[List[Int]]

  combination(list)                               //> res0: List[List[Int]] = List(List(), List(-5, 1, 4), List(-7, 1, 6), List(-5
                                                  //| , -3, 8), List(-3, -2, 1, 4), List(-5, -2, 1, 6), List(-7, -3, 4, 6), List(-
                                                  //| 7, -2, 1, 8), List(-7, -5, 4, 8), List(-5, -3, -2, 4, 6), List(-7, -3, -2, 4
                                                  //| , 8), List(-7, -5, -2, 6, 8), List(-7, -5, -3, 1, 6, 8))
  closestsum                                      //> res1: Int = 0
}
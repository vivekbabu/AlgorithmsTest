import scala.annotation.tailrec
object AllCombination {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val list = List(1,2,3)                          //> list  : List[Int] = List(1, 2, 3)
  def permute(list : List[Int]) : List[List[Int]] = {
  
  @tailrec
  def permutation(list : List[Int], acc : List[List[Int]]) : List[List[Int]] =
  	list match {
  		case Nil => acc
  		case x :: xs => permutation(xs, acc ::: acc.map(x:: _))
  }
  val permutes = permutation(list, List(List()))
  permutes.map(_.sortWith((a,b) => a<b)).sortWith((a,b) => a.length < b.length)
  }                                               //> permute: (list: List[Int])List[List[Int]]
 
 	permute(list)                             //> res0: List[List[Int]] = List(List(), List(1), List(2), List(3), List(1, 2), 
                                                  //| List(1, 3), List(2, 3), List(1, 2, 3))
 
  
}
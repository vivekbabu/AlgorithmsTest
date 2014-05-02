package in.algorithms.combination

object CombinationsWithAnyFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val list = List(1,2,3)                    //> list  : List[Int] = List(1, 2, 3)
  def combinations(list : List[Int])(fn : List[Int] => Boolean) : List[List[Int]] ={
  	@scala.annotation.tailrec
  	def combine(list : List[Int], acc : List[List[Int]]) : List[List[Int]]  = list match {
  		case Nil => acc
  		case x :: xs => combine(xs, acc ::: acc.map(x :: _))
  	}
  	
	 val combines = combine(list, Nil :: Nil)
	 combines.filter(fn).map(_.sortWith((a,b) => a<b)).sortWith((a,b)=> a.length < b.length)
  }                                               //> combinations: (list: List[Int])(fn: List[Int] => Boolean)List[List[Int]]
  
  combinations(list)(a => a.sum>0)                //> res0: List[List[Int]] = List(List(1), List(2), List(3), List(1, 2), List(1, 
                                                  //| 3), List(2, 3), List(1, 2, 3))
  
  
}
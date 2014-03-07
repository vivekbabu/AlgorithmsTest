package in.algorithms.nqeens

object NQueens {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	println("Welcome to the Scala worksheet") //> Welcome to the Scala worksheet
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val pairs = (row - 1 to 0 by -1) zip queens
    pairs forall {
      case (r, c) => col != c && Math.abs(col - c) != row - r
    }
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean
  
  def queens(n:Int) : Set[List[Int]] =  {
	  def placeQueens(k : Int) : Set[List[Int]] = {
	    if(k==0) Set(List())
	    else {
	      for {
	        queens <- placeQueens(k-1)
	        col <- 0 until n
	        if (isSafe(col, queens))
	      } yield col::queens
	      
	    }
	  }
	  placeQueens(n);
	}                                         //> queens: (n: Int)Set[List[Int]]
	
	def show(queens : List[Int]) = {
		val lines =
			for(col <- queens.reverse) yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
			//lines +
 (lines.mkString("\n"))
	}                                         //> show: (queens: List[Int])String
	//queens(4) map show
   queens(4)                                      //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
}
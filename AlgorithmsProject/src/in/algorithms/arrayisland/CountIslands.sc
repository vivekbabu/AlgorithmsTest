package in.algorithms.arrayisland

object CountIslands {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
   val ROW = 5                                    //> ROW  : Int = 5
  val COL = 5                                     //> COL  : Int = 5
  val array = Array.ofDim[Int](ROW, COL)          //> array  : Array[Array[Int]] = Array(Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0
                                                  //| ), Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0))
  var count = 0                                   //> count  : Int = 0
  val visited = Array.ofDim[Boolean](ROW, COL)    //> visited  : Array[Array[Boolean]] = Array(Array(false, false, false, false, f
                                                  //| alse), Array(false, false, false, false, false), Array(false, false, false, 
                                                  //| false, false), Array(false, false, false, false, false), Array(false, false,
                                                  //|  false, false, false))
  val indices = for {
  	 i <- -1 to 1
 		 j <- -1 to 1
 		 if(i!=0 || j!=0)
  } yield(i,j)                                    //> indices  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((-1,-1
                                                  //| ), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1))
  def populateTheArray() = {
    array(0)(0) = 1
    array(0)(1) = 1
    array(1)(1) = 1
    array(2)(0) = 1
    array(0)(3) = 1
    array(0)(4) = 1
    array(1)(4) = 1
    array(4)(0) = 1
    array(4)(2) = 1
    array(4)(4) = 1
  }                                               //> populateTheArray: ()Unit
  
  def isSafe(row : Int, col : Int) : Boolean = {
  return row < ROW && col < COL && row >=0 && col >=0 && (!visited(row)(col) && array(row)(col) == 1)
  }                                               //> isSafe: (row: Int, col: Int)Boolean
  
  def DFS(row : Int , col : Int) : Unit = {
   visited(row)(col) = true
    for {
    	(fst, sec) <- indices
    	if(isSafe(row + fst, col + sec))
    } DFS(row + fst, col + sec)
    
  }                                               //> DFS: (row: Int, col: Int)Unit
  def updateCountAndCallDFS(row : Int, col : Int) = {
  	count = count + 1
  	DFS(row, col)
  }                                               //> updateCountAndCallDFS: (row: Int, col: Int)Unit
 
 	def calculateTheIslands = {
 		for {
 		 i <- 0 to ROW - 1
 		 j <- 0 to COL - 1
 		 if(!visited(i)(j) && array(i)(j) == 1)
 		} updateCountAndCallDFS(i, j)
 		
 	}                                         //> calculateTheIslands: => Unit
 	
 	 populateTheArray
  println(array.map(_.mkString(" ")).mkString("\n"))
                                                  //> 1 1 0 1 1
                                                  //| 0 1 0 0 1
                                                  //| 1 0 0 0 0
                                                  //| 0 0 0 0 0
                                                  //| 1 0 1 0 1
   calculateTheIslands
  println(count)                                  //> 5
}
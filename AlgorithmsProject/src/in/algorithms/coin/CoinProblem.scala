package in.algorithms.coin

object CoinProblem {
	
  def countNumberOfWays(amount : Integer, denominations : List[Int]) : Int = {
    if(amount == 0) 1
    else if (amount < 0) 0
    else if(denominations.isEmpty) 0
    
    else countNumberOfWays(amount, denominations.tail) + countNumberOfWays(amount - denominations.head, denominations)
  
  }
  
  def main(args: Array[String]) {
	  println("2 with [1,2] is " + countNumberOfWays(2,List(1,2)))
	  println("5 with [1,2] is " + countNumberOfWays(5,List(1,2)))
	  println("5 with [1,2,3] is " + countNumberOfWays(5,List(1,2,3)))
}
}
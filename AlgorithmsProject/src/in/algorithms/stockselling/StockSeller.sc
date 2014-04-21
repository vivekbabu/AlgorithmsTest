package in.algorithms.stockselling

import java.util.Vector

object StockSeller {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val stockPrice = Array(100, 180, 260, 310, 40, 233, 593, 695)
                                                  //> stockPrice  : Array[Int] = Array(100, 180, 260, 310, 40, 233, 593, 695)

	def calculateStockPrice()  = {
		var  pointsToBuySell:List[(Int, Int)] = List()
		var i = 0
		while(i<= stockPrice.length && stockPrice(i) >= stockPrice(i+1)) {
			i = i + 1
		}
		if(i == stockPrice.length) {
			println("Cannot implement")
		}
		else {
		}
		
	}                                         //> calculateStockPrice: ()Unit
}
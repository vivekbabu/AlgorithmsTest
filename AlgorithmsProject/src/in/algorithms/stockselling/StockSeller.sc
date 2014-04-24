package in.algorithms.stockselling

import java.util.Vector

object StockSeller {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val stockPrice = Array(100, 180, 260, 310, 40, 233, 593, 695)
                                                  //> stockPrice  : Array[Int] = Array(100, 180, 260, 310, 40, 233, 593, 695)
  var pointsToBuySell: Array[(Int, Int)] = Array.ofDim[(Int, Int)](stockPrice.length / 2)
                                                  //> pointsToBuySell  : Array[(Int, Int)] = Array(null, null, null, null)
  var pairs: Integer = 0                          //> pairs  : Integer = 0
  def calculateStockPrice(): Unit = {

    var i = 0
    stockPrice.length
    while (i < stockPrice.length) {
      while (i < stockPrice.length && stockPrice(i) >= stockPrice(i + 1)) {
        i = i + 1
      }

      if (i == stockPrice.length) {
        println("Cannot implement")
        return
      }
      var buy = i
      i = i + 1
      while (i < stockPrice.length && stockPrice(i) >= stockPrice(i - 1)) {
        i = i + 1
      }
      var sell = i - 1
      pointsToBuySell(pairs) = (buy, sell)
      pairs = pairs + 1
    }

  }                                               //> calculateStockPrice: ()Unit
  calculateStockPrice
  for (i <- 0 to pairs - 1) {
    val (fst, sec) = pointsToBuySell(i)
    println("Buy at " + stockPrice(fst) + " and sell at " + stockPrice(sec))
  }                                               //> Buy at 100 and sell at 310
                                                  //| Buy at 40 and sell at 695

}
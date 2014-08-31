package in.algorithms.fibonacci

object DPFibonacci {

  var fibomap = Map[Long, Long]()
  var initialized = false
  def fibonacci(n: Int): Long = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def fibonacciWithDP(n: Long): Long = {
    if (!initialized) { fibomap = fibomap + (1L -> 1L) + (2L -> 1L); initialized = true }
    if (n <= 0) throw new UnsupportedOperationException()
    else if (fibomap.contains(n)) fibomap.get(n).get
    else {
      val fib = fibonacciWithDP(n - 1) + fibonacciWithDP(n - 2)
      fibomap = fibomap + (n -> fib)
      fib
    }
  }
  def main(args: Array[String]) {
    /** Using Dynamic programming */
    var start = System.currentTimeMillis();
    for (i <- 1 to 100) println("Fib of " + i + " is " + fibonacciWithDP(i))
    var end = System.currentTimeMillis();
    println("DP Took " + (end - start) / 1000 + "seconds ")
    
    /** Using normal recuresion */
    start = System.currentTimeMillis();
    for (i <- 1 to 50) println("Fib of " + i + " is " + fibonacci(i))
    end = System.currentTimeMillis();
    println("Normal Took" + (end - start) / 1000 + "seconds ")
  }

}
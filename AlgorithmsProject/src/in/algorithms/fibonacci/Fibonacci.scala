package in.algorithms.fibonacci


object Fibonacci {
  def fibonacci(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1 || n == 2) 1
    else
      fibonacci(n - 1) + fibonacci(n - 2)

  }

  def main(args: Array[String]) {
	for(i <- 0 to 10)
	  println(f"Fibonacci of $i is " + fibonacci(i))
  }
}
package in.algorithms.collections

object CollectionsTest {
	def main(args: Array[String]) {
	 val n = 100
	 val combos = (1 until n) flatMap(i => (1 until i) filter (j => isPrime(i + j)) map (j => (i,j)))
	 val combosfor = for {
	   i <- 1 until n
	   j <- 1 until i
	   if(isPrime(i+j))
	 } yield (i, j)
	 
	 println(combos.size)
	  println(combos)
	   println(combosfor.size)
	  println(combosfor)
	  
	  
}
	def isPrime(n : Int) : Boolean = {
	  def prime = false
	  val factorList = (2 until n/2+1) filter (i=> n%i==0)
	  factorList.size == 0
	}
	
}
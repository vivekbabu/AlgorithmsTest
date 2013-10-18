package in.algorithms

object Sheet {
  /** Square Root Algo **/
  def abs(x: Double): Double = {
    if (x > 0) x
    else -x
  }                                               //> abs: (x: Double)Double
  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }
    def isGoodEnough(guess: Double): Boolean = {
      abs(guess * guess - x) / x < 0.0001;
    }

    def improve(guess: Double): Double = {
      (guess + x / guess) / 2.0
    }
    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.0000000929222947
  sqrt(1e60)                                      //> res2: Double = 1.0000000031080746E30

  val x = 2                                       //> x  : Int = 2
  def f(y: Int) = y + 1                           //> f: (y: Int)Int
  val result = {
    val x = f(4)
    x * x
  } + x                                           //> result  : Int = 27

  /** gcd Algo **/
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b);
  }                                               //> gcd: (a: Int, b: Int)Int

  gcd(23, 12)                                     //> res3: Int = 1
  gcd(12, 11)                                     //> res4: Int = 1
  gcd(11, 1)                                      //> res5: Int = 1
  gcd(1, 0)                                       //> res6: Int = 1

  /** Factorial Algo **/

  def factorial(x: Int): Int = {
    def tailRecursiveFactorial(carryOverMultiplier: Int, x: Int): Int = {
      if (x == 0) carryOverMultiplier
      else tailRecursiveFactorial(carryOverMultiplier * x, x - 1)
    }
    tailRecursiveFactorial(1, x)
  }                                               //> factorial: (x: Int)Int
  factorial(5)                                    //> res7: Int = 120
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def square(x: Int): Int = x * x                 //> square: (x: Int)Int
  def id(x: Int): Int = x                         //> id: (x: Int)Int
  /*  def sum(f: Int => Int, a: Int, b: Int): Int = {
  
  	def loop(a: Int, acc : Int) : Int  = {
  	if(a>b) acc
  		else loop(a+1, f(a)+acc)
  	}
  	loop(a,0)
 //   if (a > b) 0 else f(a) + sum(f, a + 1, b)

  }*/

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {

      def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a + 1, f(a) + acc)
      }
      loop(a, 0)
    }
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  /*def sumOfInts(a: Int, b: Int): Int = {
    //  if (a > b) 0 else a + sumOfInts(a + 1, b)
    
    //sum(id, a, b)
    
    //sum( (x:Int) => x, a, b)
  	sum((x:Int) => x)
  }*/

  /*def sumOfSquares (a : Int, b : Int) : Int = {
 //  if(a>b)0
   //else square(a) + sumOfSquares(a+1,b)
   sum(x => x*x) (a,b)
   } */
  /* def sumOfCubes(a: Int, b: Int): Int = {
    //if (a > b) 0 else cube(a) + sumOfCubes(a + 1, b)
    
    //sum(cube, a, b)
    
    sum((x:Int)=> x*x*x , a, b)
  }*/

  /*  def sumOfFactorials(a: Int, b: Int): Int = {
    //  if (a > b) 0 else factorial(a) + sumOfFactorials(a + 1, b)
    sum(factorial, a, b)
  }*/

  def sumOfCubes = sum(x => x * x * x)            //> sumOfCubes: => (Int, Int) => Int
  def sumOfFactorials = sum(factorial)            //> sumOfFactorials: => (Int, Int) => Int
  def sumOfInts = sum((x: Int) => x)              //> sumOfInts: => (Int, Int) => Int
  def sumOfSquares = sum(x => x * x)              //> sumOfSquares: => (Int, Int) => Int

  //  sumOfFactorials(1, 4) + sumOfCubes(1, 4) + sumOfInts(1, 10)
  sum(factorial)(1, 4) + sum(cube)(1, 4) + sum(id)(1, 10)
                                                  //> res8: Int = 188

}
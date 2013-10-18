package in.algorithms

object Sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(130); 
  /** Square Root Algo **/
  def abs(x: Double): Double = {
    if (x > 0) x
    else -x
  };System.out.println("""abs: (x: Double)Double""");$skip(360); 
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
  };System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$0 = 

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(1e60);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); 

  val x = 2;System.out.println("""x  : Int = """ + $show(x ));$skip(24); 
  def f(y: Int) = y + 1;System.out.println("""f: (y: Int)Int""");$skip(52); 
  val result = {
    val x = f(4)
    x * x
  } + x;System.out.println("""result  : Int = """ + $show(result ));$skip(101); 

  /** gcd Algo **/
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b);
  };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(15); val res$3 = 

  gcd(23, 12);System.out.println("""res3: Int = """ + $show(res$3));$skip(14); val res$4 = 
  gcd(12, 11);System.out.println("""res4: Int = """ + $show(res$4));$skip(13); val res$5 = 
  gcd(11, 1);System.out.println("""res5: Int = """ + $show(res$5));$skip(12); val res$6 = 
  gcd(1, 0);System.out.println("""res6: Int = """ + $show(res$6));$skip(281); 

  /** Factorial Algo **/

  def factorial(x: Int): Int = {
    def tailRecursiveFactorial(carryOverMultiplier: Int, x: Int): Int = {
      if (x == 0) carryOverMultiplier
      else tailRecursiveFactorial(carryOverMultiplier * x, x - 1)
    }
    tailRecursiveFactorial(1, x)
  };System.out.println("""factorial: (x: Int)Int""");$skip(15); val res$7 = 
  factorial(5);System.out.println("""res7: Int = """ + $show(res$7));$skip(36); 
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(34); 
  def square(x: Int): Int = x * x;System.out.println("""square: (x: Int)Int""");$skip(26); 
  def id(x: Int): Int = x;System.out.println("""id: (x: Int)Int""");$skip(450); 
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
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(680); 

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

  def sumOfCubes = sum(x => x * x * x);System.out.println("""sumOfCubes: => (Int, Int) => Int""");$skip(39); 
  def sumOfFactorials = sum(factorial);System.out.println("""sumOfFactorials: => (Int, Int) => Int""");$skip(37); 
  def sumOfInts = sum((x: Int) => x);System.out.println("""sumOfInts: => (Int, Int) => Int""");$skip(37); 
  def sumOfSquares = sum(x => x * x);System.out.println("""sumOfSquares: => (Int, Int) => Int""");$skip(125); val res$8 = 

  //  sumOfFactorials(1, 4) + sumOfCubes(1, 4) + sumOfInts(1, 10)
  sum(factorial)(1, 4) + sum(cube)(1, 4) + sum(id)(1, 10);System.out.println("""res8: Int = """ + $show(res$8))}

}

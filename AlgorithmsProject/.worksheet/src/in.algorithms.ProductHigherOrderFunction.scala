package in.algorithms

import scala.annotation.tailrec

object ProductHigherOrderFunction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(137); 
  println("Welcome to the Scala worksheet");$skip(23); 

  def id(x: Int) = x;System.out.println("""id: (x: Int)Int""");$skip(31); 
  def cube(x: Int) = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(29); 
  def square(x: Int) = x * x;System.out.println("""square: (x: Int)Int""");$skip(216); 

  def fact(x: Int): Int = {
    //if(x==1) 1 else x * fact(x-1)
    @tailrec
    def factWithLoop(x: Int, acc: Int): Int = {
      if (x == 1) acc else factWithLoop(x - 1, acc * x)
    }
    factWithLoop(x, 1)
  };System.out.println("""fact: (x: Int)Int""");$skip(293); 

  /*def product(f : Int => Int) (a : Int, b : Int) : Int = {
			if(a>b) 1 else f(a) * product(f) (a+1, b)
	} */

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(98); 

  def product(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x: Int, y: Int) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(92); 
  def sum(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x: Int, y: Int) => x + y, 0)(a, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(43); val res$0 = 

  //  Product Test

  product(id)(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(24); val res$1 = 
  product(square)(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(22); val res$2 = 
  product(fact)(1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(22); val res$3 = 
  product(cube)(1, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(32); val res$4 = 

  // Sum test
  sum(id)(1, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(20); val res$5 = 
  sum(square)(1, 4);System.out.println("""res5: Int = """ + $show(res$5));$skip(18); val res$6 = 
  sum(fact)(1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(18); val res$7 = 
  sum(cube)(1, 4);System.out.println("""res7: Int = """ + $show(res$7))}

}

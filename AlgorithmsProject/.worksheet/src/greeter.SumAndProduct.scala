package in.algorithms

object SumAndProduct {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(21); 
	def id(x : Int) = x;System.out.println("""id: (x: Int)Int""");$skip(29); 
	def square(x : Int) = x * x;System.out.println("""square: (x: Int)Int""");$skip(31); 
	def cube(x : Int) = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(132); 
	def fact(x : Int) : Int = {
		def loop(x : Int, acc : Int) : Int = {
			if(x == 1) acc else loop(x-1, acc * x)
		}
		loop(x, 1)
	};System.out.println("""fact: (x: Int)Int""");$skip(311); 
	
	/*def product(f : Int => Int) (a : Int, b : Int) : Int = {
		if (a > b) 1 else f(a) * product(f)(a+1, b)
	}
	
	def sum(f : Int => Int) (a : Int, b : Int) : Int = {
		if(a>b) 0 else f(a) + sum(f)(a+1, b)
	
	}  */
	
	def product(f : Int => Int) (a : Int, b : Int) : Int = mapReduce(f, (x,y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(91); 
	
	def sum(f : Int => Int) (a : Int, b : Int) : Int = mapReduce(f, (x, y) => x+y, 0)(a, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(181); 
	
	
	def mapReduce (f : Int => Int, combine : (Int, Int) => Int, zero : Int) (a: Int, b : Int) : Int = {
		if(a>b) zero else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
	
	};System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(36); val res$0 = 
 
	// Test Product
	
	sum(id) (1,4);System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
	sum(square) (1,4);System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
	sum(fact) (1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
	sum(cube) (1,4);System.out.println("""res3: Int = """ + $show(res$3));$skip(38); val res$4 = 
	// Test Product
	
	product(id) (1,4);System.out.println("""res4: Int = """ + $show(res$4));$skip(23); val res$5 = 
	product(square) (1,4);System.out.println("""res5: Int = """ + $show(res$5));$skip(22); val res$6 = 
	product(fact) (1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(21); val res$7 = 
	product(cube) (1,4);System.out.println("""res7: Int = """ + $show(res$7))}
}

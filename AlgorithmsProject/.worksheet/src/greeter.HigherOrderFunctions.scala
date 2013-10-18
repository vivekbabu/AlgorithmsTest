package in.algorithms

object HigherOrderFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  println("Welcome to the Scala worksheet");$skip(20); 
	def id(x: Int) = x;System.out.println("""id: (x: Int)Int""");$skip(27); 
	def cube(x : Int) = x*x*x;System.out.println("""cube: (x: Int)Int""");$skip(27); 
	def square(x : Int) = x*x;System.out.println("""square: (x: Int)Int""");$skip(187); 
	def fact(x : Int) : Int = {
		//if(x==1) 1 else x * fact(x-1)
		def factWithLoop(x : Int, acc : Int) : Int = {
			if(x==1) acc else factWithLoop(x-1, acc * x)
		}
		factWithLoop(x,1)
	};System.out.println("""fact: (x: Int)Int""");$skip(89); 
	def sumOfInts(a : Int, b : Int) : Int = {
		if(a>b) 0 else id(a) + sumOfInts(a+1, b)
	};System.out.println("""sumOfInts: (a: Int, b: Int)Int""");$skip(102); 
	
	def sumOfSquares(a : Int, b : Int) : Int = {
			if(a>b) 0 else square(a) + sumOfSquares(a+1, b)
	};System.out.println("""sumOfSquares: (a: Int, b: Int)Int""");$skip(105); 
	
	def sumOfFactorial(a : Int, b : Int) : Int = {
		if(a>b) 0 else fact(a) + sumOfFactorial(a+1, b)
	
	};System.out.println("""sumOfFactorial: (a: Int, b: Int)Int""");$skip(95); 
	
	def sumOfCube(a : Int, b : Int) : Int = {
		if(a>b) 0 else cube(a) + sumOfCube(a+1, b)
	
	};System.out.println("""sumOfCube: (a: Int, b: Int)Int""");$skip(100); 
	
	def sum(f : Int => Int, a : Int, b : Int ) : Int = {
		if(a>b) 0 else f(a) + sum(f, a+1, b)
	
	};System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(158); 
	
	def sumWithoutParameters(f : Int => Int) : (Int,Int) => Int = {
		def sum(a : Int, b : Int ) : Int = {
		if(a>b) 0 else f(a) + sum(a+1, b)
	
	}
	sum
		
	};System.out.println("""sumWithoutParameters: (f: Int => Int)(Int, Int) => Int""");$skip(137); 
	
	def sumWithDirectParameter(f : Int => Int)  (a : Int, b : Int) : Int = {
		if(a>b) 0 else f(a) + sumWithDirectParameter(f) (a+1,b)
	};System.out.println("""sumWithDirectParameter: (f: Int => Int)(a: Int, b: Int)Int""");$skip(33); val res$0 = 
	
	// Tests Here
	sumOfInts(1,4);System.out.println("""res0: Int = """ + $show(res$0));$skip(20); val res$1 = 
	sumOfSquares(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(22); val res$2 = 
	sumOfFactorial(1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
	sumOfCube(1, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(56); val res$4 = 
	
	// The above can also be written as
	
	sum(id, 1, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(19); val res$5 = 
	sum(square, 1, 4);System.out.println("""res5: Int = """ + $show(res$5));$skip(17); val res$6 = 
	sum(fact, 1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(17); val res$7 = 
	sum(cube, 1, 4);System.out.println("""res7: Int = """ + $show(res$7));$skip(78); val res$8 = 
	
	// The parameterLess versions of the above
	sumWithoutParameters(id) (1,4);System.out.println("""res8: Int = """ + $show(res$8));$skip(36); val res$9 = 
	sumWithoutParameters(square) (1,4);System.out.println("""res9: Int = """ + $show(res$9));$skip(34); val res$10 = 
	sumWithoutParameters(fact) (1,4);System.out.println("""res10: Int = """ + $show(res$10));$skip(34); val res$11 = 
	sumWithoutParameters(cube) (1,4);System.out.println("""res11: Int = """ + $show(res$11));$skip(84); val res$12 = 
	
	// The simplified form of sumWithoutParameters
	sumWithDirectParameter(id) (1,4);System.out.println("""res12: Int = """ + $show(res$12));$skip(38); val res$13 = 
	sumWithDirectParameter(square) (1,4);System.out.println("""res13: Int = """ + $show(res$13));$skip(36); val res$14 = 
	sumWithDirectParameter(fact) (1,4);System.out.println("""res14: Int = """ + $show(res$14));$skip(36); val res$15 = 
	sumWithDirectParameter(cube) (1,4);System.out.println("""res15: Int = """ + $show(res$15));$skip(99); 
	
	// Testing the partial function
	
	def testPartial( f : (Int,Int) => Int) : Int = {
		f(1,4)
	};System.out.println("""testPartial: (f: (Int, Int) => Int)Int""");$skip(44); val res$16 = 
	
	testPartial(sumWithDirectParameter(id)_);System.out.println("""res16: Int = """ + $show(res$16))}
}

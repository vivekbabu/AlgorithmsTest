package in.algorithms

object ProductHigherOrderFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def id(x: Int) = x                              //> id: (x: Int)Int
  def cube(x: Int) = x * x * x                    //> cube: (x: Int)Int
  def square(x: Int) = x * x                      //> square: (x: Int)Int
  def fact(x: Int): Int = {
    //if(x==1) 1 else x * fact(x-1)
    def factWithLoop(x: Int, acc: Int): Int = {
      if (x == 1) acc else factWithLoop(x - 1, acc * x)
    }
    factWithLoop(x, 1)
  }                                               //> fact: (x: Int)Int

  /*def product(f : Int => Int) (a : Int, b : Int) : Int = {
			if(a>b) 1 else f(a) * product(f) (a+1, b)
	} */

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x: Int, y: Int) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  def sum(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x: Int, y: Int) => x + y, 0)(a, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int

  //  Product Test

  product(id)(1, 4)                               //> res0: Int = 24
  product(square)(1, 4)                           //> res1: Int = 576
  product(fact)(1, 4)                             //> res2: Int = 288
  product(cube)(1, 4)                             //> res3: Int = 13824

  // Sum test
  sum(id)(1, 4)                                   //> res4: Int = 10
  sum(square)(1, 4)                               //> res5: Int = 30
  sum(fact)(1, 4)                                 //> res6: Int = 33
  sum(cube)(1, 4)                                 //> res7: Int = 100

}
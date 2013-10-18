package in.algorithms

object HigherOrderFunctions {
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
  def sumOfInts(a: Int, b: Int): Int = {
    if (a > b) 0 else id(a) + sumOfInts(a + 1, b)
  }                                               //> sumOfInts: (a: Int, b: Int)Int

  def sumOfSquares(a: Int, b: Int): Int = {
    if (a > b) 0 else square(a) + sumOfSquares(a + 1, b)
  }                                               //> sumOfSquares: (a: Int, b: Int)Int

  def sumOfFactorial(a: Int, b: Int): Int = {
    if (a > b) 0 else fact(a) + sumOfFactorial(a + 1, b)

  }                                               //> sumOfFactorial: (a: Int, b: Int)Int

  def sumOfCube(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumOfCube(a + 1, b)

  }                                               //> sumOfCube: (a: Int, b: Int)Int

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int

  def sumWithoutParameters(f: Int => Int): (Int, Int) => Int = {
    def sum(a: Int, b: Int): Int = {
      if (a > b) 0 else f(a) + sum(a + 1, b)

    }
    sum

  }                                               //> sumWithoutParameters: (f: Int => Int)(Int, Int) => Int

  def sumWithDirectParameter(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sumWithDirectParameter(f)(a + 1, b)
  }                                               //> sumWithDirectParameter: (f: Int => Int)(a: Int, b: Int)Int

  // Tests Here
  sumOfInts(1, 4)                                 //> res0: Int = 10
  sumOfSquares(1, 4)                              //> res1: Int = 30
  sumOfFactorial(1, 4)                            //> res2: Int = 33
  sumOfCube(1, 4)                                 //> res3: Int = 100

  // The above can also be written as

  sum(id, 1, 4)                                   //> res4: Int = 10
  sum(square, 1, 4)                               //> res5: Int = 30
  sum(fact, 1, 4)                                 //> res6: Int = 33
  sum(cube, 1, 4)                                 //> res7: Int = 100

  // The parameterLess versions of the above
  sumWithoutParameters(id)(1, 4)                  //> res8: Int = 10
  sumWithoutParameters(square)(1, 4)              //> res9: Int = 30
  sumWithoutParameters(fact)(1, 4)                //> res10: Int = 33
  sumWithoutParameters(cube)(1, 4)                //> res11: Int = 100

  // The simplified form of sumWithoutParameters
  sumWithDirectParameter(id)(1, 4)                //> res12: Int = 10
  sumWithDirectParameter(square)(1, 4)            //> res13: Int = 30
  sumWithDirectParameter(fact)(1, 4)              //> res14: Int = 33
  sumWithDirectParameter(cube)(1, 4)              //> res15: Int = 100

  // Testing the partial function

  def testPartial(f: (Int, Int) => Int): Int = {
    f(1, 4)
  }                                               //> testPartial: (f: (Int, Int) => Int)Int

  testPartial(sumWithDirectParameter(id)_)        //> res16: Int = 10
}
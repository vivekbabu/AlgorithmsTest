package in.algorithms.smallestsubarray

object SmallestSubArray {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val array = List(1, 11, 100, 1, 0, 200, 3, 2, 1, 250)
                                                  //> array  : List[Int] = List(1, 11, 100, 1, 0, 200, 3, 2, 1, 250)

  def smallestSubArray(list: List[Int], x: Int): Int = {
    var start = 0
    var end = 0
    var currentSum = 0
    var minLength = list.length + 1

    while (end < list.length) {
      while (currentSum <= x && end < list.length) {
         currentSum = currentSum + list(end)
        end = end + 1
       
      }

      while (currentSum > x && start < list.length) {
        if (end - start < minLength)
          minLength = end - start
          currentSum = currentSum - list(start)
        start = start + 1
        
      }
    }
  minLength
}                                                 //> smallestSubArray: (list: List[Int], x: Int)Int
  smallestSubArray(array, 280)                    //> res0: Int = 4

}
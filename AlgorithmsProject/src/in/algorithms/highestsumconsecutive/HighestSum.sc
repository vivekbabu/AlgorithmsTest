package in.algorithms.highestsumconsecutive

object HighestSum {
  println("Prints the highest sum of 2 consecutive numbers")
                                                  //> Prints the highest sum of 2 consecutive numbers
  def highestSum(list : List[Int], currentMax : Int, previous : Int) : Int = {
    if(list.isEmpty) currentMax
    else if(list.head + previous > currentMax)
      highestSum(list.tail, list.head + previous, list.head)
    else
      highestSum(list.tail, currentMax, list.head)
  }                                               //> highestSum: (list: List[Int], currentMax: Int, previous: Int)Int
  var giveList = List(1,4,5,7,10,19,9,8,12,1,22)  //> giveList  : List[Int] = List(1, 4, 5, 7, 10, 19, 9, 8, 12, 1, 22)
  highestSum(giveList, 0, 0)                      //> res0: Int = 29
  
  
  
}
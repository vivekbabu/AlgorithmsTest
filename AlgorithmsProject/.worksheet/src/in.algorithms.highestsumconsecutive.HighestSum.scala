package in.algorithms.highestsumconsecutive

object HighestSum {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(125); 
  println("Prints the highest sum of 2 consecutive numbers");$skip(283); 
  def highestSum(list : List[Int], currentMax : Int, previous : Int) : Int = {
    if(list.isEmpty) currentMax
    else if(list.head + previous > currentMax)
      highestSum(list.tail, list.head + previous, list.head)
    else
      highestSum(list.tail, currentMax, list.head)
  };System.out.println("""highestSum: (list: List[Int], currentMax: Int, previous: Int)Int""");$skip(49); 
  var giveList = List(1,4,5,7,10,19,9,8,12,1,22);System.out.println("""giveList  : List[Int] = """ + $show(giveList ));$skip(29); val res$0 = 
  highestSum(giveList, 0, 0);System.out.println("""res0: Int = """ + $show(res$0))}
  
  
  
}

package greeter

object KMPAlgorithm {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  println("Welcome to the Scala worksheet");$skip(209); 

//  var S = "ABC ABCDAB ABCDABCDABDE" // The string
//  var W = "ABCDABD" // The pattern to match
//  var T = new Array[Int](W.length()) // The computed substing table
    var S = "AAAAAAAAAAA";System.out.println("""S  : String = """ + $show(S ));$skip(43);  // The string
  var W = "AAAAAB";System.out.println("""W  : String = """ + $show(W ));$skip(68);  // The pattern to match
  var T = new Array[Int](W.length());System.out.println("""T  : Array[Int] = """ + $show(T ));$skip(22);  // The computed substing table
  var comparisons = 0;System.out.println("""comparisons  : Int = """ + $show(comparisons ));$skip(335); 
  def calculateTheTable() {
    T(0) = -1
    T(1) = 0
    var pos = 2
    var cnd = 0
    while (pos < W.length()) {
      if (W(pos - 1) == W(cnd)) {
        cnd = cnd + 1
        T(pos) = cnd
        pos = pos + 1
      } else if (cnd > 0)
        cnd = T(cnd);
      else {
        cnd = 0
        pos = pos + 1
      }

    }
  };System.out.println("""calculateTheTable: ()Unit""");$skip(583); 

  def kmpAlgorithm(): Int = {
    calculateTheTable()
    var m = 0
    var i = 0
    while (m + i < S.length()) {
    comparisons = comparisons + 1
    println(comparisons+ " " + S(m+i) + " on " +(m+i)+ " with " + W(i) +" on " + i + " is " + i)
      if (W(i) == S(m + i)) {
        if (i == W.length() - 1) return m
        i = i + 1;
      } else {
      
        if (T(i) > 0) {
          m = m + i - T(i)
          i = T(i)
        } else {
          
          m = m + i + 1
          i = 0
        }

      }
    }
 		// This comment has been added
    return S.length()
  };System.out.println("""kmpAlgorithm: ()Int""");$skip(12); val res$0 = 
	S.length();System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  kmpAlgorithm();System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  comparisons;System.out.println("""res2: Int = """ + $show(res$2))}
}

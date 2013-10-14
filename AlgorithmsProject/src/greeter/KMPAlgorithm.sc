package greeter

object KMPAlgorithm {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

//  var S = "ABC ABCDAB ABCDABCDABDE" // The string
//  var W = "ABCDABD" // The pattern to match
//  var T = new Array[Int](W.length()) // The computed substing table
    var S = "AAAAAAAAAAA" // The string           //> S  : String = AAAAAAAAAAA
  var W = "AAAAAB" // The pattern to match        //> W  : String = AAAAAB
  var T = new Array[Int](W.length()) // The computed substing table
                                                  //> T  : Array[Int] = Array(0, 0, 0, 0, 0, 0)
  var comparisons = 0                             //> comparisons  : Int = 0
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
  }                                               //> calculateTheTable: ()Unit

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
  }                                               //> kmpAlgorithm: ()Int
	S.length()                                //> res0: Int = 11
  kmpAlgorithm()                                  //> 1 A on 0 with A on 0 is 0
                                                  //| 2 A on 1 with A on 1 is 1
                                                  //| 3 A on 2 with A on 2 is 2
                                                  //| 4 A on 3 with A on 3 is 3
                                                  //| 5 A on 4 with A on 4 is 4
                                                  //| 6 A on 5 with B on 5 is 5
                                                  //| 7 A on 5 with A on 4 is 4
                                                  //| 8 A on 6 with B on 5 is 5
                                                  //| 9 A on 6 with A on 4 is 4
                                                  //| 10 A on 7 with B on 5 is 5
                                                  //| 11 A on 7 with A on 4 is 4
                                                  //| 12 A on 8 with B on 5 is 5
                                                  //| 13 A on 8 with A on 4 is 4
                                                  //| 14 A on 9 with B on 5 is 5
                                                  //| 15 A on 9 with A on 4 is 4
                                                  //| 16 A on 10 with B on 5 is 5
                                                  //| 17 A on 10 with A on 4 is 4
                                                  //| res1: Int = 11
  comparisons                                     //> res2: Int = 17
}
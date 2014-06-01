package in.algorithms.levenstein

object Levenstein {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def distance(s1: String, s2: String): Int = {
    val costArray = Array.tabulate(s1.length() + 1, s2.length() + 1)((i, j) => if (i == 0) j else if (j == 0) i else 0)
    def min(m1: Int, m2: Int, m3: Int) = Math.min(Math.min(m1, m2), m3)

    for {
      i <- 1 to s1.length()
      j <- 1 to s2.length()
    }costArray(i)(j) =  if (s1(i - 1) == s2(j - 1))  costArray(i - 1)(j - 1) else min(costArray(i - 1)(j) + 1, costArray(i)(j - 1) + 1, costArray(i - 1)(j - 1) + 1)
    costArray(s1.length())(s2.length())
  }                                               //> distance: (s1: String, s2: String)Int

  distance("kitten", "sitting")                   //> res0: Int = 3
  distance("rosettacode", "raisethysword")        //> res1: Int = 8

}
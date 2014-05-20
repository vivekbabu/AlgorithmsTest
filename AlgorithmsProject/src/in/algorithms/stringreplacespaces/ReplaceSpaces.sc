package in.algorithms.stringreplacespaces

object ReplaceSpaces {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val spacesString = "Welcome to the Scala worksheet"
                                                  //> spacesString  : String = Welcome to the Scala worksheet

  def replaceSpaces(givenString: String): String = {
    var spacesCount = 0;
    for (i <- 0 to givenString.length() - 1) {
      if (givenString.charAt(i) == ' ') spacesCount = spacesCount + 1
    }
    if (spacesCount == 0) givenString
    else {
      val newString = Array.ofDim[Character](givenString.length() + spacesCount * 2)
      var newLength = givenString.length() + spacesCount * 2
      newLength = newLength -1
      for (i <- givenString.length() - 1 to 0 by -1) {
        if (givenString.charAt(i) == ' ') {
          newString(newLength ) = '0'
          newString(newLength - 1) = '2'
          newString(newLength - 2) = '\\'
          newLength = newLength - 3

        } else {
          newString(newLength) = givenString.charAt(i)
          newLength = newLength - 1
        }
      }
        newString.mkString

    }
  }                                               //> replaceSpaces: (givenString: String)String
  
  println(replaceSpaces(spacesString))            //> Welcome\20to\20the\20Scala\20worksheet
}
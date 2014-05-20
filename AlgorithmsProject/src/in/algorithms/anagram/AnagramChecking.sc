package in.algorithms.anagram

object AnagramChecking {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val firstString = "geeksforgeeks"               //> firstString  : String = geeksforgeeks
  val secondString = "forgeeksgeeks"              //> secondString  : String = forgeeksgeeks
  
  def checkIfAnagrams(string1: String, string2: String) : Boolean = {
  	if(string1.length() != string2.length()) false
  	else {
  	var uniqueCharacters = 0
  		val characterCount = Array.ofDim[Int](256)
  		for(i <- 0 to string1.length()  - 1) {
  			val character = string1.charAt(i).toInt
  			if (characterCount(character) == 0) uniqueCharacters = uniqueCharacters +1
  			characterCount(character) = characterCount(character) + 1
  		}
  		
  		for(i <- 0 to string2.length() -1) {
  			val character = string2.charAt(i).toInt
  			if (characterCount(character) == 0) false
  			characterCount(character) = characterCount(character) -1
  			if(characterCount(character) == 0) uniqueCharacters = uniqueCharacters -1
  			if(uniqueCharacters == 0) return i == string2.length() -1
  		}
  		
  	false
  	}
  
  }                                               //> checkIfAnagrams: (string1: String, string2: String)Boolean
  checkIfAnagrams(firstString, secondString)      //> res0: Boolean = true
}
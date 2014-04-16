package in.algorithms.duplicatecharacters

object DuplicateCharacterChecker {
  def checkIfContainsDuplicateCharacters(sentence : String) : Boolean = {
    val charBooleans : Array[Boolean] = Array.ofDim(256)
    for(i <- 0 to sentence.length() - 1) {
      val character = sentence(i)
      if(charBooleans(character)) return true
      else charBooleans(character) = true
    }
    return false
  }

  def main(args: Array[String]) {
   println( checkIfContainsDuplicateCharacters("Aabc"))
   println( checkIfContainsDuplicateCharacters("Vivek babu"))
   
  }

}
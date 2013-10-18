package in.algorithms

object Palindrome {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def palindromeCheck(palindrome : String) : Boolean = {
  	var isPalindrome = true
  	var j = palindrome.length() -1
  	for(i <- 0 to palindrome.length()/2) {
				  	if(palindrome(i)!=palindrome(j)) isPalindrome =false
				  	j = j - 1
  	}
  	isPalindrome
  }                                               //> palindromeCheck: (palindrome: String)Boolean
  
  assert(palindromeCheck("malayalam"), "The given string is not a palindrome")
}
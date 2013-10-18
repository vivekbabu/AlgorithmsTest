package in.algorithms

object Palindrome {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  println("Welcome to the Scala worksheet");$skip(272); 

  def palindromeCheck(palindrome: String): Boolean = {
    var isPalindrome = true
    var j = palindrome.length() - 1
    for (i <- 0 to palindrome.length() / 2) {
      if (palindrome(i) != palindrome(j)) isPalindrome = false
      j = j - 1
    }
    isPalindrome
  };System.out.println("""palindromeCheck: (palindrome: String)Boolean""");$skip(80); 

  assert(palindromeCheck("malayalam"), "The given string is not a palindrome")}
}

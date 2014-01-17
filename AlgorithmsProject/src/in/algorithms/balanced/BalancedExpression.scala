package in.algorithms.balanced

object BalancedExpression {

  def checkIfBalanced(givenString: String, currentCount: Int): Boolean = {
    if (givenString.isEmpty()) currentCount == 0
    else if (givenString.head == '(') checkIfBalanced(givenString.tail, currentCount + 1)
    else if ((givenString.head == ')')) currentCount > 0 && checkIfBalanced(givenString.tail, currentCount - 1)
    else checkIfBalanced(givenString.tail, currentCount)
  }
  
  def main(args: Array[String]) {
	  println("(a+b)-((a-b))*(b) is balanced :"+ checkIfBalanced("(a+b)-((a-b))*(b)", 0) )
	  println("a+b)-((a-b))*(b) is balanced :"+ checkIfBalanced("a+b)-((a-b))*(b)", 0) )
}
}
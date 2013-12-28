package in.algorithms.decomposition.casesolution

object ExprSimulator {

  def main(args: Array[String]) {
    var expr = new Sum(new Number(6), new Sum(new Number(3), new Number(5)))
    println(expr.eval)
    println(expr.show)
  }

}
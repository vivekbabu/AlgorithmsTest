package in.algorithms.decomposition.badapproach

object ExprSimulator {
  def eval(expr: Expr): Integer = {
    if (expr.isInstanceOf[Number]) expr.asInstanceOf[Number].num
    else if (expr.isInstanceOf[Sum]) eval(expr.asInstanceOf[Sum].leftOp) + eval(expr.asInstanceOf[Sum].rightOp)
    else throw new Error("Unknow expression" + expr)

  }
  def main(args: Array[String]) {
    var expr = new Sum(new Number(6),new Sum(new Number(3), new Number(5)))
    println(eval(expr))
  }

} 
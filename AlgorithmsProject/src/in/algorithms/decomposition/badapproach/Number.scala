package in.algorithms.decomposition.badapproach

class Number(n : Integer) extends Expr {
  def isNum = true
  def isSum = false
  def leftOp = throw new Error("leftOp of Number")
  def rightOp = throw new Error("rightOp of Number")
  def num = n
}
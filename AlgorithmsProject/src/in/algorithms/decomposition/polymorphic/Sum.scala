package in.algorithms.decomposition.polymorphic

class Sum(e1 : Expr , e2 : Expr) extends Expr {
  
  def eval = e1.eval + e2.eval

}
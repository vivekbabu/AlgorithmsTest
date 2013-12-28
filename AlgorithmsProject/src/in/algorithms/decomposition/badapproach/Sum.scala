package in.algorithms.decomposition.badapproach

class Sum(left : Expr, right : Expr) extends Expr {
	def isNum = false
	def isSum = true
	def leftOp = left
	def rightOp = right
	def num = throw new Error("Num value of sum")
	}
package in.algorithms.decomposition.badapproach

trait Expr {
	def isNum : Boolean
	def isSum : Boolean
	def leftOp : Expr
	def rightOp : Expr
	def num : Integer	
}
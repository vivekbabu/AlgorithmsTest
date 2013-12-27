package in.algorithms.list

import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] { 
  def isEmpty = false
}

class Nil[T] extends List[T] {
	def isEmpty = true
	def head : Nothing = throw new NoSuchElementException("Nil Head")
	def tail: Nothing = throw new NoSuchElementException("Nil Tail")
  
}

package in.algorithms.listfunctions

object ListFunctions {
   def sort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case y :: ys => insert(y, sort(ys))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => List(x)
      case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
    }
  }
  
  def head[T](xs: List[T]): T = {
    xs match {
      case List() => throw new Error("Head of empty list")
      case y :: ys => y
    }
  }
  def tail[T](xs: List[T]): List[T] = {
    xs match {
      case List() => throw new Error("Tail of empty list")
      case y :: ys => ys
    }
  }

  def last[T](xs: List[T]): T = {
    xs match {
      case List() => throw new Error("Last of empty list")
      case List(x) => x
      case y :: ys => last(ys)
    }
  }
  
  def concat[T](xs : List[T], ys : List[T]) : List[T] = {
    xs match {
      case List() => ys
      case z :: zs => z :: concat(zs, ys)
    }
  }
  
  def init[T](xs : List[T]) : List[T] = {
    xs match {
      case List() => throw new Error("Init of empty list")
      case List(x) => List()
      case y :: ys => y :: init(ys)
    }
  }
  
  def reverse[T](xs : List[T]) : List[T] = {
    xs match {
      case List() => List()
      case y :: ys => reverse(ys) ++ List(y)
    }
  }

  def main(args: Array[String]) {
    val list = List(2, 1, 3, 6, 5, 4)
    val list2 = List(7,8,9)
    println(head(list))
    println(tail(list))
    println(last(list))
    println(init(list))
    println(sort(list))
    println(concat(sort(list), list2))
    println(reverse(list))
  }
}
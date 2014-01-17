package in.algorithms.listfunctions

object ListFunctions {
  def map[T, U](xs: List[T])(f: T => U): List[U] = {
    xs match {
      case List() => Nil
      case x :: xs => f(x) :: map(xs)(f)
    }

  }

  def filter[T](xs: List[T])(f: T => Boolean): List[T] = {
    xs match {
      case List() => Nil
      case y :: ys =>
        if (f(y)) y :: filter(ys)(f) else filter(ys)(f)

    }
  }
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

  def scalelist(xs: List[Int], factor: Double): List[Double] = {
    map(xs)((x) => x * factor)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case z :: zs => z :: concat(zs, ys)
    }
  }

  def init[T](xs: List[T]): List[T] = {
    xs match {
      case List() => throw new Error("Init of empty list")
      case List(x) => List()
      case y :: ys => y :: init(ys)
    }
  }

  def reverse[T](xs: List[T]): List[T] = {
    xs match {
      case List() => List()
      case y :: ys => reverse(ys) ++ List(y)
    }
  }

  def posElementsOfList(xs: List[Int]): List[Int] = {
    xs match {
      case List() => Nil
      case y :: ys => if (y > 0) y :: posElementsOfList(ys) else posElementsOfList(ys)
    }
  }
  
  def pack[T](xs : List[T]) : List[List[T]] = {
    
    xs match {
      case List() => Nil
      case y :: ys => {
        val (fir,rest) = xs.span(n => n== y) 
        		fir :: pack(rest)
      }
    }
  }
  
  def encode[T] (xs : List[T]) : List[(T, Int)] = {
    
    pack(xs).map(ys => (ys.head	,ys.length))
  }

  def main(args: Array[String]) {
    val list = List(2, 1, 3, 6, 5, 4)
    val list2 = List(7, 8, 9)
    val list3 = List(3, -3, 4, -4, -5, 6, -7, -9)
    val list4 = List('a','a','a','b','b','b','b','c','c','c','c','c','c','a','c')
    println(head(list))
    println(tail(list))
    println(last(list))
    println(init(list))
    println(sort(list))
    println(concat(sort(list), list2))
    println(reverse(list))
    println(map(list)((x: Int) => x * 4.0))
    println(scalelist(list, 4))
    println(posElementsOfList(list3))
    println(filter(list3)((x:Int) => x > 0))
    println(pack(list4))
    println(encode(list4))
    println ( 0 :: list reduceLeft(_+_))
    println(1 :: list reduceLeft(_*_))
    println( list.foldLeft(0)(_+_))
    println(list.foldLeft(1)(_*_))
    
  }
}
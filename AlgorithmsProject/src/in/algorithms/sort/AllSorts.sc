package in.algorithms.sort

object AllSorts {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println("hello")                                //> hello
  def quicksort[T](xs: List[T], lt: (T, T) => Boolean, eq: (T, T) => Boolean): List[T] = {
    if (xs.length < 2) xs
    else {
      val pivot = xs(xs.length / 2)
      quicksort(xs.filter(lt(_, pivot)), lt, eq) ++ xs.filter(eq(_, pivot)) ++ quicksort(xs.filter(lt(pivot, _)), lt, eq)
    }
  }                                               //> quicksort: [T](xs: List[T], lt: (T, T) => Boolean, eq: (T, T) => Boolean)Lis
                                                  //| t[T]
  def insertionsort[T](xs: List[T], lt: (T, T) => Boolean): List[T] = {
    def insert[T](x: T, xs: List[T], lt: (T, T) => Boolean): List[T] = {
      xs match {
        case List() => List(x)
        case y :: ys => if (lt(x, y)) x :: xs else y :: insert(x, ys, lt)
      }
    }

    xs match {
      case List() => List()
      case x :: ys => insert(x, insertionsort(ys, lt), lt)
    }

  }                                               //> insertionsort: [T](xs: List[T], lt: (T, T) => Boolean)List[T]

  def mergesort[T](xs: List[T], lt: (T, T) => Boolean): List[T] = {
    def merge[T](xs: List[T], ys: List[T], lt: (T, T) => Boolean): List[T] = {
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys, lt) else y :: merge(xs, ys1, lt)
      }
    }
    if (xs.length < 2) xs
    else {
      val (fst, sec) = xs.splitAt(xs.length / 2)
      merge(mergesort(fst, lt), mergesort(sec, lt), lt)
    }
  }                                               //> mergesort: [T](xs: List[T], lt: (T, T) => Boolean)List[T]

  val list = List(2, 1, 3, 6, 5, 4)               //> list  : List[Int] = List(2, 1, 3, 6, 5, 4)
  quicksort(list, ((a: Int, b: Int) => a < b), ((a: Int, b: Int) => a == b))
                                                  //> res0: List[Int] = List(1, 2, 3, 4, 5, 6)
  insertionsort(list, ((a: Int, b: Int) => a < b))//> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
  mergesort(list, ((a: Int, b: Int) => a < b))    //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)
}
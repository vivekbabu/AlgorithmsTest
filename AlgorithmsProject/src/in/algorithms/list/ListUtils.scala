package in.algorithms.list

object nth {
  def nth[T](n: Integer, list: List[T]): T = {
    if (list.isEmpty) throw new ArrayIndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  }
  

  def main(args: Array[String]) {
    val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Nil)))))
    println (nth(4,list))
    println(nth(2,list))
  }

}
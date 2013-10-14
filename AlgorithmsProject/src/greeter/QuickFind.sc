package greeter

object QuickFind {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var size = 10;                                  //> size  : Int = 10
  var id = new Array[Int](size);                  //> id  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  def intialiseTheNodes(): Unit = {
    for (i <- 0 to size - 1)
      id(i) = i;
  }                                               //> intialiseTheNodes: ()Unit

  def union(p: Int, q: Int): Unit = {
    var pid = id(p);
    var qid = id(q)

    for (i <- 0 to size - 1) {
      if (id(i) == pid) {
        id(i) = qid;
      }
    }
  }                                               //> union: (p: Int, q: Int)Unit

  def connected(p: Int, q: Int): Boolean = {
    return id(p) == id(q)
  }                                               //> connected: (p: Int, q: Int)Boolean

  intialiseTheNodes()
  union(4, 3)
  union(3, 8)
  union(5, 6)
  union(9, 4)
  union(2, 1)
  union(8, 9)
  union(5, 0)
  union(7, 2)
  union(6, 1)

  id                                              //> res0: Array[Int] = Array(1, 1, 1, 8, 8, 1, 1, 1, 8, 8)
}
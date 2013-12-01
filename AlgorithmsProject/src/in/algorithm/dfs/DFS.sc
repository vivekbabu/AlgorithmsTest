package in.algorithm.dfs
import scala.annotation.tailrec
import scala.collection.Map
import scala.collection.Set
object DFS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var graph = Map(0 -> Set[Int](1),
    1 -> Set[Int](2),
    2 -> Set[Int](3, 4),
    3 -> Set[Int](5, 6),
    4 -> Set[Int](3),
    5 -> Set[Int](),
    6 -> Set[Int](0))                             //> graph  : scala.collection.Map[Int,scala.collection.Set[Int]] = Map(0 -> Set(
                                                  //| 1), 5 -> Set(), 1 -> Set(2), 6 -> Set(0), 2 -> Set(3, 4), 3 -> Set(5, 6), 4 
                                                  //| -> Set(3))

  def traverseFrom[A](graph: Map[A, Set[A]], initial: A) = {
    @tailrec
    def traverseTR[A](graph: Map[A, Set[A]], toVisit: Seq[A], visited: Set[A], accumulator: Seq[A]): Seq[A] = {
      if (toVisit.isEmpty) {
        accumulator
      } else {
        val next = toVisit.head
        val succ = (graph(next) -- visited -- toVisit).toSeq
        traverseTR(graph, succ ++ toVisit.tail, visited + next, accumulator :+ next)
      }
    }
    traverseTR(graph, Seq(initial), Set.empty, Seq.empty)

  }                                               //> traverseFrom: [A](graph: scala.collection.Map[A,scala.collection.Set[A]], in
                                                  //| itial: A)Seq[A]
  traverseFrom[Int](graph, 1)                     //> res0: Seq[Int] = List(1, 2, 3, 5, 6, 0, 4)
}
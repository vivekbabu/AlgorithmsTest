package in.algorithm.dfs
import scala.annotation.tailrec

object DFS1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(116); 
  println("Welcome to the Scala worksheet");$skip(173); 
  var graph = Map(0 -> Set[Int](1),
    1 -> Set[Int](2),
    2 -> Set[Int](3, 4),
    3 -> Set[Int](5, 6),
    4 -> Set[Int](3),
    5 -> Set[Int](),
    6 -> Set[Int](0));System.out.println("""graph  : scala.collection.immutable.Map[Int,scala.collection.immutable.Set[Int]] = """ + $show(graph ));$skip(541); 

  def dfsTraversal[A](graph: Map[A, Set[A]], initial: A) = {
    @tailrec
    def dfsTraversalRecursive[A](graph: Map[A, Set[A]], toVisit: Seq[A], visited: Set[A], accumulator: Seq[A]): Seq[A] = {
      if (toVisit.isEmpty)
        accumulator
      else {
        var next = toVisit.head
        var succ = (graph(next) -- toVisit -- visited).toSeq
        dfsTraversalRecursive(graph, succ ++ toVisit.tail , visited + next, accumulator :+ next)
      }

    }
    dfsTraversalRecursive[A](graph, Seq(initial), Set.empty, Seq.empty)
  };System.out.println("""dfsTraversal: [A](graph: Map[A,Set[A]], initial: A)Seq[A]""");$skip(24); val res$0 = 
	dfsTraversal(graph, 1);System.out.println("""res0: Seq[Int] = """ + $show(res$0))}
}

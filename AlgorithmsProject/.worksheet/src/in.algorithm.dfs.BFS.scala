package in.algorithm.dfs
import scala.annotation.tailrec
object BFS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  println("Welcome to the Scala worksheet");$skip(175); 

  var graph = Map(0 -> Set[Int](1),
    1 -> Set[Int](2),
    2 -> Set[Int](3, 4),
    3 -> Set[Int](5, 6),
    4 -> Set[Int](3),
    5 -> Set[Int](),
    6 -> Set[Int](0));System.out.println("""graph  : scala.collection.immutable.Map[Int,scala.collection.immutable.Set[Int]] = """ + $show(graph ));$skip(516); 

  def traverseFrom[A](graph: Map[A, Set[A]], initial: A): Seq[A] = {
    @tailrec
    def traverseTR[A](graph: Map[A, Set[A]], toVisit: Seq[A], visited: Set[A], accumulator: Seq[A]): Seq[A] = {
      if (toVisit.isEmpty) {
        accumulator
      } else {
        val next = toVisit.head
        val succ = (graph(next) -- visited -- toVisit).toSeq
        traverseTR(graph, toVisit.tail ++ succ, visited + next, accumulator :+ next)
      }
    }
    traverseTR(graph, Seq(initial), Set.empty, Seq.empty)

  };System.out.println("""traverseFrom: [A](graph: Map[A,Set[A]], initial: A)Seq[A]""");$skip(30); val res$0 = 
  traverseFrom[Int](graph, 1);System.out.println("""res0: Seq[Int] = """ + $show(res$0))}
}

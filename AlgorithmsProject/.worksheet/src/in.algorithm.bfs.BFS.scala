package in.algorithm.bfs
import scala.annotation.tailrec
object BFS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  println("Welcome to the Scala worksheet");$skip(173); 
  var graph = Map(0 -> Set[Int](1),
    1 -> Set[Int](2),
    2 -> Set[Int](3, 4),
    3 -> Set[Int](5, 6),
    4 -> Set[Int](3),
    5 -> Set[Int](),
    6 -> Set[Int](0));System.out.println("""graph  : scala.collection.immutable.Map[Int,scala.collection.immutable.Set[Int]] = """ + $show(graph ));$skip(485); 

  def bfsVisit[A](graph: Map[A, Set[A]], initial: A): Seq[A] = {
    @tailrec
    def bfsVisitRec[A](graph: Map[A, Set[A]], toVisit: Seq[A], visited: Set[A], acc: Seq[A]): Seq[A] = {
      if (toVisit.isEmpty)
        acc
      else {
        def next = toVisit.head
        def succ = (graph(next) -- toVisit -- visited).toSeq
        bfsVisitRec(graph, toVisit.tail ++ succ, visited + next, acc :+ next)
      }
    }
    bfsVisitRec(graph, Seq(initial), Set.empty, Seq.empty)
  };System.out.println("""bfsVisit: [A](graph: Map[A,Set[A]], initial: A)Seq[A]""");$skip(23); val res$0 = 

  bfsVisit(graph, 1);System.out.println("""res0: Seq[Int] = """ + $show(res$0))}
}

package in.algorithm.bfs

object BFS1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(174); 
   var graph = Map(0 -> Set[Int](1),
    1 -> Set[Int](2),
    2 -> Set[Int](3, 4),
    3 -> Set[Int](5, 6),
    4 -> Set[Int](3),
    5 -> Set[Int](),
    6 -> Set[Int](0));System.out.println("""graph  : scala.collection.immutable.Map[Int,scala.collection.immutable.Set[Int]] = """ + $show(graph ));$skip(190); 
    
    
    def bfsVisit[T](graph : Map[T,Set[T]], initial : T) : Seq[T] = {
    	def bfsVisitRec(graph : Map[T,Set[T]], initial : T) : Seq[T] = {
    	Seq.empty
    }
    Seq.empty
    };System.out.println("""bfsVisit: [T](graph: Map[T,Set[T]], initial: T)Seq[T]""")}
    
}

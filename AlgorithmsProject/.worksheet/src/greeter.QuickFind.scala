package in.algorithms

object QuickFind {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(17); 
  var size = 10;System.out.println("""size  : Int = """ + $show(size ));$skip(33); ;
  var id = new Array[Int](size);System.out.println("""id  : Array[Int] = """ + $show(id ));$skip(86); ;
  def intialiseTheNodes(): Unit = {
    for (i <- 0 to size - 1)
      id(i) = i;
  };System.out.println("""intialiseTheNodes: ()Unit""");$skip(177); 

  def union(p: Int, q: Int): Unit = {
    var pid = id(p);
    var qid = id(q)

    for (i <- 0 to size - 1) {
      if (id(i) == pid) {
        id(i) = qid;
      }
    }
  };System.out.println("""union: (p: Int, q: Int)Unit""");$skip(76); 

  def connected(p: Int, q: Int): Boolean = {
    return id(p) == id(q)
  };System.out.println("""connected: (p: Int, q: Int)Boolean""");$skip(23); 

  intialiseTheNodes();$skip(14); 
  union(4, 3);$skip(14); 
  union(3, 8);$skip(14); 
  union(5, 6);$skip(14); 
  union(9, 4);$skip(14); 
  union(2, 1);$skip(14); 
  union(8, 9);$skip(14); 
  union(5, 0);$skip(14); 
  union(7, 2);$skip(14); 
  union(6, 1);$skip(6); val res$0 = 

  id;System.out.println("""res0: Array[Int] = """ + $show(res$0))}
}

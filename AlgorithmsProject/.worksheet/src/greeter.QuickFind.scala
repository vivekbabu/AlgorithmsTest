package greeter

object QuickFind {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(16); 
	var size = 10;System.out.println("""size  : Int = """ + $show(size ));$skip(32); ;
	var id = new Array[Int](size);System.out.println("""id  : Array[Int] = """ + $show(id ));$skip(90); ;
  def intialiseTheNodes() : Unit = {
 		 for( i <- 0 to size - 1)
         id(i) = i;
  };System.out.println("""intialiseTheNodes: ()Unit""");$skip(200); 
  
  def union(p : Int, q : Int) : Unit = {
 			 var pid = id(p);
 			 var qid = id(q)
 			 
 			 for( i <- 0 to size - 1){
         if(id(i) == pid) {
         			id(i) = qid;
         }
      }
  };System.out.println("""union: (p: Int, q: Int)Unit""");$skip(86); 
  
    def connected (p : Int, q : Int) : Boolean = {
  		return id(p) == id(q)
    };System.out.println("""connected: (p: Int, q: Int)Boolean""");$skip(27); 
    
  intialiseTheNodes();$skip(15); 
    union(4,3);$skip(15); 
    union(3,8);$skip(15); 
    union(5,6);$skip(15); 
    union(9,4);$skip(15); 
    union(2,1);$skip(15); 
    union(8,9);$skip(15); 
    union(5,0);$skip(15); 
    union(7,2);$skip(15); 
    union(6,1);$skip(12); val res$0 = 
    
    id;System.out.println("""res0: Array[Int] = """ + $show(res$0))}
}

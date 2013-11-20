package in.algorithms.intsets

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
val t1 = new NonEmpty(10, Empty, Empty);System.out.println("""t1  : in.algorithms.intsets.NonEmpty = """ + $show(t1 ));$skip(19); 
val t2 = t1 incl 3;System.out.println("""t2  : in.algorithms.intsets.IntSet = """ + $show(t2 ));$skip(19); 
val t3 = t2 incl 4;System.out.println("""t3  : in.algorithms.intsets.IntSet = """ + $show(t3 ));$skip(19); 
val tq = t3 incl 9;System.out.println("""tq  : in.algorithms.intsets.IntSet = """ + $show(tq ));$skip(39); 

val t4= new NonEmpty(7, Empty, Empty);System.out.println("""t4  : in.algorithms.intsets.NonEmpty = """ + $show(t4 ));$skip(19); 
val t5 = t4 incl 3;System.out.println("""t5  : in.algorithms.intsets.IntSet = """ + $show(t5 ));$skip(19); 
val t6 = t5 incl 8;System.out.println("""t6  : in.algorithms.intsets.IntSet = """ + $show(t6 ));$skip(22); 

val t7 = tq union t6;System.out.println("""t7  : in.algorithms.intsets.IntSet = """ + $show(t7 ))}
}


object Empty extends IntSet {

override def incl(x : Int) : IntSet = new NonEmpty(x, Empty, Empty)
override def contains(x : Int) : Boolean = false
override def toString = "."
def union(other : IntSet) : IntSet = other
}


class NonEmpty(element : Int, left : IntSet , right : IntSet) extends IntSet {
  override def incl(x : Int) : IntSet = {
    if(x < element) new NonEmpty(element, left incl x , right)
    else if (x > element) new NonEmpty(element, left , right incl x)
    else this
  }
  override def contains(x : Int) : Boolean = {
    if(x > element) right contains x
    else if (x < element) left contains x
    else true
  }
  override def toString = "{" + left + element + right + "}"
  override def union(other : IntSet) : IntSet = ((left union right) union other) incl element
}
abstract class IntSet {

def incl(x : Int) : IntSet
def contains(x : Int) : Boolean
def union(other : IntSet) : IntSet
}

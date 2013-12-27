package in.algorithms.intsets

object intsets {
val t1 = new NonEmpty(10, Empty, Empty)           //> t1  : in.algorithms.intsets.NonEmpty = {.10.}
val t2 = t1 incl 3                                //> t2  : in.algorithms.intsets.IntSet = {{.3.}10.}
val t3 = t2 incl 4                                //> t3  : in.algorithms.intsets.IntSet = {{.3{.4.}}10.}
val tq = t3 incl 9                                //> tq  : in.algorithms.intsets.IntSet = {{.3{.4{.9.}}}10.}

val t4= new NonEmpty(7, Empty, Empty)             //> t4  : in.algorithms.intsets.NonEmpty = {.7.}
val t5 = t4 incl 3                                //> t5  : in.algorithms.intsets.IntSet = {{.3.}7.}
val t6 = t5 incl 8                                //> t6  : in.algorithms.intsets.IntSet = {{.3.}7{.8.}}

val t7 = tq union t6                              //> t7  : in.algorithms.intsets.IntSet = {{.3{.4.}}7{.8{.9{.10.}}}}

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
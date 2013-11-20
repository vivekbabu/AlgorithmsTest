package in.algorithms.intsets

object intsets {
val t1 = new NonEmpty(10, Empty, Empty)           //> t1  : in.algorithms.intsets.NonEmpty = {.10.}
val t2 = t1 incl 3                                //> t2  : in.algorithms.intsets.IntSet = {{.3.}10.}
val t3 = t2 incl 4                                //> t3  : in.algorithms.intsets.IntSet = {{.3{.4.}}10.}
}


object Empty extends IntSet {

override def incl(x : Int) : IntSet = new NonEmpty(x, Empty, Empty)
override def contains(x : Int) : Boolean = false
override def toString = "."
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
}
abstract class IntSet {

def incl(x : Int) : IntSet
def contains(x : Int) : Boolean

}
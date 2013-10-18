package in.algorithms

object Hello extends App {
  def and(x: Boolean, y: Boolean): Boolean = {
    if (x) y
    else false
  }
  
   def or(x: Boolean, y: Boolean): Boolean = {
    if (x)true
    else y
  }
  println(and(false, true));
  println(or(false, false));
}
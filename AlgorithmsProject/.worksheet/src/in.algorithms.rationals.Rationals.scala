package in.algorithms.rationals

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  val rational1 = new Rational(2, 3);System.out.println("""rational1  : in.algorithms.rationals.Rational = """ + $show(rational1 ));$skip(37); 
  val rational2 = new Rational(1, 2);System.out.println("""rational2  : in.algorithms.rationals.Rational = """ + $show(rational2 ));$skip(27); val res$0 = 
  rational1.add(rational2);System.out.println("""res0: in.algorithms.rationals.Rational = """ + $show(res$0));$skip(33); val res$1 = 
  rational1.add(rational2).neg();System.out.println("""res1: in.algorithms.rationals.Rational = """ + $show(res$1));$skip(27); val res$2 = 
  rational1.sub(rational2);System.out.println("""res2: in.algorithms.rationals.Rational = """ + $show(res$2));$skip(32); 
  
  val  x = new Rational(1,3);System.out.println("""x  : in.algorithms.rationals.Rational = """ + $show(x ));$skip(29); 
  val  y = new Rational(5,7);System.out.println("""y  : in.algorithms.rationals.Rational = """ + $show(y ));$skip(29); 
  val  z = new Rational(3,2);System.out.println("""z  : in.algorithms.rationals.Rational = """ + $show(z ));$skip(18); val res$3 = 
  x.add(y).mul(z);System.out.println("""res3: in.algorithms.rationals.Rational = """ + $show(res$3))}
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational): Rational = {
    new Rational(this.numer * that.denom + this.denom * that.numer, this.denom * that.denom)
  }

  def neg(): Rational = {
    new Rational(-this.numer, this.denom)
  }

  def sub(that: Rational): Rational = {
    add(that.neg)
  }
  
  
  def mul(that: Rational): Rational = {
    new Rational(this.numer * that.numer, this.denom * that.denom)
  }
  

  override def toString = numer + "/" + denom
}

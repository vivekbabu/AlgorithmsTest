package in.algorithms.rationals

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  val rational1 = new Rational(2, 3);System.out.println("""rational1  : in.algorithms.rationals.Rational = """ + $show(rational1 ));$skip(37); 
  val rational2 = new Rational(1, 2);System.out.println("""rational2  : in.algorithms.rationals.Rational = """ + $show(rational2 ));$skip(24); val res$0 = 
  rational1 + rational2;System.out.println("""res0: in.algorithms.rationals.Rational = """ + $show(res$0));$skip(25); val res$1 = 
  rational1 + -rational2;System.out.println("""res1: in.algorithms.rationals.Rational = """ + $show(res$1));$skip(24); val res$2 = 
  rational1 - rational2;System.out.println("""res2: in.algorithms.rationals.Rational = """ + $show(res$2));$skip(31); 

  val x = new Rational(1, 3);System.out.println("""x  : in.algorithms.rationals.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : in.algorithms.rationals.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : in.algorithms.rationals.Rational = """ + $show(z ));$skip(14); val res$3 = 

  x + y * z;System.out.println("""res3: in.algorithms.rationals.Rational = """ + $show(res$3));$skip(8); val res$4 = 
  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(11); val res$5 = 
  x.max(y);System.out.println("""res5: in.algorithms.rationals.Rational = """ + $show(res$5));$skip(37); 

  val strange = new Rational(1, 1);System.out.println("""strange  : in.algorithms.rationals.Rational = """ + $show(strange ));$skip(18); val res$6 = 
  new Rational(5);System.out.println("""res6: in.algorithms.rationals.Rational = """ + $show(res$6))}
}

class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)
  require(y != 0, "Denominator must not be zero")

  val numer = x
  val denom = y

  def +(that: Rational): Rational = {
    new Rational(this.numer * that.denom + this.denom * that.numer, this.denom * that.denom)
  }

  def unary_- : Rational = {
    new Rational(-this.numer, this.denom)
  }

  def -(that: Rational): Rational = {
    this + -that
  }

  def *(that: Rational): Rational = {
    new Rational(this.numer * that.numer, this.denom * that.denom)
  }

  def <(that: Rational): Boolean = {
    this.numer * that.denom - that.numer * this.denom < 0
  }

  def max(that: Rational): Rational = {
    if (this < that) that else this

  }

  override def toString = {

    def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}

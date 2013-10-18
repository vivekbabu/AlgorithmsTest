package in.algorithms.rationals

object Rationals {
  val rational1 = new Rational(2, 3)              //> rational1  : in.algorithms.rationals.Rational = 2/3
  val rational2 = new Rational(1, 2)              //> rational2  : in.algorithms.rationals.Rational = 1/2
  rational1 + rational2                           //> res0: in.algorithms.rationals.Rational = 7/6
  rational1 + -rational2                          //> res1: in.algorithms.rationals.Rational = 1/6
  rational1 - rational2                           //> res2: in.algorithms.rationals.Rational = 1/6

  val x = new Rational(1, 3)                      //> x  : in.algorithms.rationals.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : in.algorithms.rationals.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : in.algorithms.rationals.Rational = 3/2

  x + y * z                                       //> res3: in.algorithms.rationals.Rational = 59/42
  x < y                                           //> res4: Boolean = true
  x.max(y)                                        //> res5: in.algorithms.rationals.Rational = 5/7

  val strange = new Rational(1, 1)                //> strange  : in.algorithms.rationals.Rational = 1/1
  new Rational(5)                                 //> res6: in.algorithms.rationals.Rational = 5/1
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
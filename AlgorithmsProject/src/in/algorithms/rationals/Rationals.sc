package in.algorithms.rationals

object Rationals {
  val rational1 = new Rational(2, 3)              //> rational1  : in.algorithms.rationals.Rational = 2/3
  val rational2 = new Rational(1, 2)              //> rational2  : in.algorithms.rationals.Rational = 1/2
  rational1.add(rational2)                        //> res0: in.algorithms.rationals.Rational = 7/6
  rational1.add(rational2).neg()                  //> res1: in.algorithms.rationals.Rational = -7/6
  rational1.sub(rational2)                        //> res2: in.algorithms.rationals.Rational = 1/6
  
  val  x = new Rational(1,3)                      //> x  : in.algorithms.rationals.Rational = 1/3
  val  y = new Rational(5,7)                      //> y  : in.algorithms.rationals.Rational = 5/7
  val  z = new Rational(3,2)                      //> z  : in.algorithms.rationals.Rational = 3/2
  x.add(y).mul(z)                                 //> res3: in.algorithms.rationals.Rational = 66/42
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
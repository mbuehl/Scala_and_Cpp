class Rational(x: Int, y: Int)
{
  require(y > 0, "denominator must be positive")

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def numer = x / gcd( x, y)
  def denom = y / gcd( x, y)


  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom)

  def neg() = new Rational(-this.numer, this.denom)

  def + (r: Rational) =  new Rational(
        this.numer * r.denom + r.numer * this.denom,
        this.denom * r.denom)

  def unary_- (r: Rational) =  new Rational(
        this.numer * r.denom + -r.numer * this.denom,
        this.denom * r.denom)

  def makeString(r: Rational) =
    r.numer + "/" + r.denom

  override def toString() = makeString(this)
}


val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

"/> xneg() = " + x.neg()

"/> x + y = " + (x + y)
"/> x - y = " + (x unary_- y)
"/> z - y - x = " + (z unary_- y unary_- x )




def abs( x: Double) : Double = if( x > 0.0) x else -x

abs(-3.9999)


def sqrt(x: Double): Double = {

  def iterSqrt(guess: Double, x: Double): Double =
  {
    if(isGood(guess, x: Double))  guess
    else iterSqrt(makeItBetter(guess: Double, x: Double), x)
  }

  def isGood(guess: Double, x: Double): Boolean =
  {
    abs(guess*guess - x) / x < 0.0001
  }

  def makeItBetter(guess: Double, x: Double) =
  {
    (guess + x/guess) /2
  }


  iterSqrt(1.0, x)
}


sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)
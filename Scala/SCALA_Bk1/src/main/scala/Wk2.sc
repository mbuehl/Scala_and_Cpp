//x function or anonimous    bounds
//x       function
def sum(fn: Int => Int)(a: Int, b: Int): Int =
{
  if (a > b) 0
  else fn(a) + sum(fn)(a + 1, b)

}

// anonymous fn def   bounds
sum(x => x + x + x)(1, 2)

// fn2 - explicit fn def
def fn2(a: Int) = 3 * a
sum(fn2)(1, 2)

//---------------------------------------------

def product(fn: Int => Int)(a: Int, b: Int): Int =
{
  if (a > b) 1
  else fn(a) * product(fn)(a + 1, b)

}

"product (x*x) 3*3  *  4*4: " + product(x => x * x)(3, 4)
"product (fn2) 3*3  *  4*4: " + product(fn2)(3, 4)

//----------------------------------------------
// based on product def

def factorial(n: Int) = product(x => x)(1, n)

"Factorial: " + factorial(5)

//----------------------------------------------
//  Fixed points ... SquareRoot

def abs(x: Double) = if(x > 0) x else -x

def isCloseEnough(guess: Double, x: Double): Boolean =
{
   val tolerance = 0.001;
   abs(guess * guess - x) / x < tolerance
}
/*
x   fixedPoint
x   -----------
x   is where   f(x) = x  for  sqrt ... y = x/y
x
*/
def fixedPoint(f: Double => Double)(firstGuess: Double) =
{
  def iterate(guess: Double): Double =
  {
    val next = f(guess)
    println(next)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }

  iterate(firstGuess)
}

def sqrtFP(x: Double) = fixedPoint(y =>  (y + x / y) / 2 )(1.0)

//"1.-->  sqrtFP(2):  "  +  sqrtFP(2)


/*
x   averageDamp
x   -----------
x
x   Then, the iteration converges by averaging successive values.
x   This technique of stabilizing by averaging is general enough to merit
x   being abstracted into its own function
*/

def averageDamp(f: Double => Double)(x: Double) =
{
  println("x = " + x + " \t\tf(x) = " + f(x))
  (x + f(x)) / 2
}

//def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)

def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y )) (1.0)

println("\n\n")

"2.-->  sqrt(2):  "  +  sqrt(2)




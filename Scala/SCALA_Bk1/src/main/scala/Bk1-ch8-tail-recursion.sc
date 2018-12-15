//x        --   8.9 Tail recursion   --         2017/03/19
// Versions of approximate is preferable? In terms of brevity and var avoidance,
// the first, functional one wins. But is the imperative approach perhaps more efficient?
// In fact, if we measure execution times it turns out that they are almost exactly the same!

//x           Using functional style -  RECURSIVE CALLS -

def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))

//Warn: Functions like approximate, which call themselves as their last action, are called tail recursive.

//x           Using imperative style - LOOP
def approximateLoop(initialGuess: Double): Double = {
  var guess = initialGuess
  while (!isGoodEnough(guess))
    guess = improve(guess)
  guess
}
def isGoodEnough(xx: Double):Boolean = ???
def improve(xx: Double):Double = ???

//Warn:  The moral is that you should not shy away from using recursive algorithms to solve your problem. Often, a recursive solution is more elegant and concise than a loop-based one. If
//Warn:  the solution is tail recursive, there won’t be any runtime overhead to be paid.

//x----------------------------------------------------------------------------

//Warn: This function is not tail recursive, because it performs an increment operation after the recursive call.
//def boom(x: Int): Int =
//  if (x == 0) throw new Exception("boom!")
//  else boom(x - 1) + 1
//
//boom(3)

def bang(x: Int): Int =
  if (x == 0) throw new Exception("bang!")
  else bang(x - 1)

//bang(5)


def isEven(x: Int): Boolean =
  if (x == 0) true else isOdd(x - 1)
def isOdd(x: Int): Boolean =
  if (x == 0) false else isEven(x - 1)

isEven(445)

/*
8.10 Conclusion
This chapter has given you a grand tour of functions in Scala.
In addition to methods, Scala provides local functions, function literals,
and function values. In addition to normal function calls, Scala provides
partially applied functions and functions with repeated parameters. When possible,
function calls are implemented as optimized tail calls, and thus many nice-looking
recursive functions run just as quickly as hand-optimized versions that use while
loops. The next chapter will build on these foundations and show how Scala’s
rich support for functions helps you abstract over control.
 */
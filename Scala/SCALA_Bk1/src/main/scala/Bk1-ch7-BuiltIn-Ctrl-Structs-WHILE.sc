/*Scala’s while loop behaves as in other languages. It has a condition and a
body, and the body is executed over and over as long as the condition holds
true
x--Listing 7.2 · Calculating greatest common divisor with a while loop.*/

def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}
//operate on tuple
def gcdLoop(A: (Long, Long)): Long = gcdLoop(A._1, A._2)

val dziel = (54l, 33l)

val gcdVal = gcdLoop(dziel)
"gcdLoop(54, 33)= " + gcdVal + "\t\t 54/gcd= " + (54 / gcdVal)


//-------------------------------------------------------------------
//instead of gcdLoop
println("** Instead of gcdLoop - functional programming version - using recursion **\n")
def gcd(x: Long, y: Long): Long =  if (y == 0) x else gcd(y, x % y)
//operate on tuple
def gcd(A: (Long, Long)): Long = gcd(A._1, A._2)


"gcd(" + dziel._1 + ", " + dziel._2 + ")= " + gcd(dziel) + "\t\t " + dziel._1 +
  "/gcd= " + (dziel._1 / gcd(dziel))

//-------------------------------------------------------------------
/*Scala also has a do-while loop. This works like the while loop except
that it tests the condition after the loop body instead of before. Listing 7.3
shows a Scala script that uses a dowhile to echo lines read from the standard
input, until an empty line is entered:
*/

var line = "abc\ncde \n"
do {
  line = scala.io.StdIn.readLine()
  println("Read: " + line)
} while (line != "")
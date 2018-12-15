import java.io.File

val filesHere = (new java.io.File(".")).listFiles
(new java.io.File(".")).getAbsolutePath

for (file <- filesHere)
  println(file)

for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)

def gcd(x: Long, y: Long): Long =
  if (y == 0) x else gcd(y, x % y)

"max common divisor for (75, 10) = " +  gcd(75, 10)

for (i <- 1  to 4)
  println("Iteration "+ i + " ")


//Given a positive integer n, find all pairs of //positive integers i and j ,
// where 1 GE j < i < n such that (i + j) is prime
val n = 10
def isPrime(n: Int) =
  List.range(2, n/2) forall (x => n % x != 0)

for { i <- List.range(1, n)           //.   take all  i  from range
      j <- List.range(1, i)           //.   take all  j  from range
      if isPrime(i+j)
    } yield (i,  j)                   //.   if  i+j is prime then print it
import scala.collection.immutable.{List, Nil}

//x Another common operatin on lists is to combine elements of list
//x using a give operator ....  reduceLeft, reduceRight,
//x                             foldLeft or ':/', foldRight  or ':\'

//Note:  For operators that arr associative and cummulative foldLeft and foldRight
//Note:  are equivalent. Sometimes only one of the two is appropriate.

//Note:  Reduce(-Left -Right) are defined in terms of more general function.
//Note:  FoldLeft is like ReduceLeft but takes an accumulator as additional parms
//Note:  which is returned when foldLeft is call on EMPTY.

//Exmp1:    Sum(list(x1,x2,...xn))   = 0 + x1 +...+ xn
//Exmp2:    Product(list(x1,x2,...xn))   = 1 * x1 *...* xn

//-> we can implement using pattern matching as:

val ls = List(4,2,44,1,7,-59,-1)
val ls2 = List(0,1,0)

def sumPatMtch(xs: List[Int]): Int = xs match {
  case Nil      => 0
  case y :: ys  => y + sumPatMtch(ys)
}

sumPatMtch(ls)

//This pattern can be ABSTRACTED OUT using generic method  x reduceLeft:
//x--   list(x1,x2,...xn)  reduceLeft op  = (..( x1 op x2) op...) op xn

def sumRedLft(xs: List[Int]) =  (0 :: xs)  reduceLeft((x,y) => x + y)

sumRedLft(ls)

//x ...or for short using generic

def sumRedLft2(xs: List[Int])     =  (0 :: xs)  reduceLeft (_ + _)
def productRedLft2(xs: List[Int]) =  (1 :: xs)  reduceLeft (_ * _)

sumRedLft2(ls)
productRedLft2(ls)

//x ...,or using    foldLeft

//x-- (ist(x1,x2,...xn) foldleft z) op  = (..( z op x1) op...) op xn

// Where: z - is the accumulator with initil value 0 for sum and 1 for product

def sumFoldLeft(xs: List[Int])     = (xs foldLeft 0)(_ + _)
def prdctFoldLeft(xs: List[Int])   = (xs foldLeft 1)(_ * _)

def prdctFoldLeftAbbrev(xs: List[Int])   = (1 /: xs)(_ * _)

"sumFoldLeft:         " + sumFoldLeft(ls)
"prdctFoldLeft:       " + prdctFoldLeft(ls)
"prdctFoldLeftAbbrev: " + prdctFoldLeftAbbrev(ls)


//x   concat implementation using   foldLeft and foldRight

def concatR[T] (xs: List[T], ys: List[T]): List[T] =
  (xs foldRight ys)(_ :: _)

"(xs foldRight ys)(_ :: _) = " + concatR(ls,ls2)

//Note:                                         foldRight  ====   :\
def concatRabbrev[T] (xs: List[T], ys: List[T]): List[T] =
  (xs :\ ys)(_ :: _)

"(xs :\\ ys)(_ :: _) = " + concatRabbrev(ls,ls2)

//Warn:  type error - foldLeft and foldRight are not interchangable

//def concatL[T] (xs: List[T], ys: List[T]): List[T] =
//  (xs foldLeft ys)(_ :: _)
//
//concatL(ls,ls2)

//Note:       :: - is called 'cons'  operation

def reverse[T](xs: List[T]): List[T] =
  (xs foldLeft List[T]())((xs, x) => x :: xs)

reverse(ls)

//x                     Adopted from List.scala  - non-recursive
def reverse2[A](xs: List[A]): List[A] = {
  var result: List[A] = Nil
  var these = xs
  while (!these.isEmpty) {
    result = these.head :: result
    these = these.tail
  }
  result
}

"reverse - Adopted from List.scala - non-recursive: " + reverse(ls)

//x                     My way - recursive with pattern matching
def reverseMy[A](xs: List[A]): List[A] = xs match {
  case Nil      => Nil
  case x :: xs1 => reverseMy(xs1) ::: List(x)
}

"reverse list - recursive with pattern matching: " + reverseMy(ls)





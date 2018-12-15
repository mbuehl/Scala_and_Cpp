//chpt 16  Lists

val lsInt =  List(1,2,3,4,5,6,7,8)
val lsChr =  List('a','b','c','d','z')

//technique:  recursion
def reverse[T](in: List[T]):List[T] = {
  if(in == Nil) Nil
  else
    reverse(in.tail) ::: List(in.head)
}

reverse (lsInt)
reverse (lsChr)

//technique:  case matching
def reverse2[T](p_in: List[T]):List[T] = p_in match {
  case List ()=>  throw new Error ("Empty list" )
  case Nil =>  Nil
  case in :: inx => reverse(inx) ::: List(in)
}

//x--
reverse2 (lsInt)
reverse2 (lsChr)
//reverse2 (List())

//x--

def mltpChr(a: Char, n: Int): String = {
  val sb = new StringBuilder()
  for(x <- 0 until n) sb.append(a)
  sb.toString()
}
//x--
lsInt.map(  2 * _ )
lsChr.map( mltpChr(_,3) )
lsChr.map( mltpChr(_,3) ) zip lsInt
(lsChr.map( mltpChr(_,3) ) zip lsInt) unzip

//x--
//    xs span p equals (xs takeWhile p, xs dropWhile p)
val xs = List(1, 2, 3, -4, 5)

xs span (_ > 0)
xs.takeWhile(_ > 0);   xs.dropWhile(_ > 0)
xs.takeWhile(_ < 0);   xs.dropWhile(_ < 0)


def flattenLeft[T](xss: List[List[T]]) =
(List[T]() /: xss) (_ ::: _)
def flattenRight[T](xss: List[List[T]]) =
(xss :\ List[T]()) (_ ::: _)

"flattenLeft  = " + flattenLeft(List(xs))
"flattenright = " + flattenRight(List(xs))

val words = List("the", "quick", "brown", "fox")
("" /: words) (_ + "   " + _)
(words :\ "" ) (_ + "   " + _)




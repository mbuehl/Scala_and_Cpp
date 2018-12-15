import scala.collection.immutable.::

val lst1 = List('0', '1', '2', '3', '4', '5', '6', '7')
val lst2 = List('A', 'B', 'b', 'D')

val lst11 = List("AN","Wa","BY", "k", "az","1x3")
val lst21 = List("77","a","0","16","3")


lst1.length
lst1.last

"list consisting of first n elements: " + lst1.take(3)
"list consisting of elements starting from n: " + lst1 drop 4
"5th element: " + lst1(4)

lst1.head
lst1.tail

println("concat: " + (lst1 ++ lst2))

"reverse: " + lst2.reverse
"concat then reverse: " + (lst1 ++ lst2).reverse

"updated: " + lst1.updated(5, 't')

//lst1.updated( AnyRef, 'a')

"indexof: " + lst1.indexOf('f')
"contains: " + lst1.contains('f')


def lastX[T](xs: List[T]): T = xs match {
  case List ()=>  throw new Error ("last of empty list" )
  case List(x ) =>   x
  case y :: ys  =>  lastX ( ys)
}
"lastX: " + lastX(lst1)

"List object level concat  - lst1 :: lst2  =>> " + lst1 :: lst2
"List element level concat - lst1 ::: lst2 =>> " + ( lst1 ::: lst2)

def concatX[T] (xs: List[T], ys: List[T]):List[T]  = xs match {
  case List() => ys
  case z :: zs  => z :: concatX(zs,ys)
}
"concatX[T] (xs: List[T], ys: List[T]):List[T] " + concatX(lst2,lst1)


def concatY[T] (xs: List[T], ys: List[T]):List[T]  = xs match {
  case List() => ys
  case z  =>  z.head :: concatY(z.tail,ys)
}
"concatY " + concatY(lst2,lst1)

lst11.head
lst11.tail
"concatY lst11 + lst21 take 2 + "  + concatY( concatY(lst11,lst21 take 2), lst1.take(4)  )

lst11.sorted
"sortBY all uppercased: " + lst11.sortBy( x => x.toUpperCase())

def srt2ndChr(x: String): String =
{
  if(x.length == 0 ) x
  if(x.length == 1 ) "zz" + x
  else x.toLowerCase().charAt(1).toString
}

"sortBY - srt-by-2nd-Chr: " + ((lst11:::lst21).sortBy( srt2ndChr ))



















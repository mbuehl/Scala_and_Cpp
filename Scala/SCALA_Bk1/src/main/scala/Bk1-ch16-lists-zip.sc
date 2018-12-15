//x   chpt 16.6 lists  zip, unzip                                                           -
//x                                                                                         -
val lst = List(1,2,3,4,5,6,7,8,9)
val lstCh = List('a','b','c','d','e')
//x                                                                                         -
lst.zip(lstCh)
lstCh.zip(lst)
//x                                                                                         -
lst.zip(lstCh).unzip
lst.zip(lstCh).unzip._1 ::: lst.zip(lstCh).unzip._2
//x                                                                                         -
"lstCh.zipWithIndex = "+ (lstCh.zipWithIndex)
//x                                                                                         -
//x                                                                                         -
//x  16.5 The pattern List(a, b, c) matches lists of length 3, and binds the three          -
//x  the three elements to the pattern variables a, b, and c                                -
//x                                                                                         -
val fruit = "apples" :: ("oranges" :: ("pears" :: ("bubu" :: Nil)))
val List(a, b, c, d) = fruit
println("println b = " +b)
//x                                                                                         -
//Warn    If you don’t know the number
//Warn    of list elements beforehand, it’s better to match with :: instead. For instance,
//Warn    the pattern a :: b :: rest matches lists of length 2 or greater
//x                                                                                         -
val a3 :: b3 :: rest = fruit
println("println rest = " + rest)

//x  ----------------------------------------------------------------------------------------
//x  16.6  A method is first-order if it does not take any functions as arguments           -
//x        Concatenating two lists                                                          -
//x                                                                                         -
List(1, 2) ::: List(3, 4, 5)
//x
//x        The Divide and Conquer principle                                                 -
//x
//x        The most common pattern match over lists simply distinguishes an empty from      -
//x        a non-empty list.                                                                -
//x                                                                                         -
def divideAndConquerPrinciple[T](xs: List[T], ys: List[T]): List[T] =  xs match {
  case List() =>  ???
  case x :: xs1 => ???
}
//x                                                                                         -
//x                                                                                         -
def append[T](xs: List[T], ys: List[T]): List[T] =  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
}
//x     chpt 16.7 Higher-order methods on class List                                        -
append(List(1,2,3),List(5,7))
//x                                                                                         -
val words = List("the", "quick", "brown", "fox")
words map (_.length)
words map (_.toList)
//x                                                                                         -
words flatMap (_.toList)
//x
words map (_.length)
words map (_.toList.reverse.mkString)
//
"words map (_.toList) = " + (words map (_.toList))
"words flatMap (_.toList) = " + (words flatMap (_.toList))
//x The differences and interplay between map and flatMap are also demonstrated by the following expression,
//x which constructs a list of all pairs (i; j) such that 1  j < i < 5                                                                                        -

List.range(1, 5) flatMap (  i => List.range(1, i) map (j => (i, j))  )

//List.range is a utility method that creates a list of all integers in some range.
//It is used twice in this example: once to generate a list of integers from 1 (including) until 5
// (excluding), and in a second time to generate a list of integers from 1 until i, for each value of
// i taken from the first list.
//The map in this expression generates a list of tuples (i; j) where j < i. The outer flatMap in this
// example generates this list for each i between 1 and 5, and then concatenates all the results...

//x   and the eqivalent for above...
for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)
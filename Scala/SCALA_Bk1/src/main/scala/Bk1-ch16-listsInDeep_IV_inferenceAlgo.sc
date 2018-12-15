//x   16.10 Understanding Scala’s type inference algorithm  Warn: Type inference in Scala is flow based
//warn                                ^^^^^^^^^^^
//x            operation n, n+1          list        ret type
def msort[T](less: (T, T) => Boolean) (xs: List[T]): List[T] =
{
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>                  //    x .. xs1          y...ys1
        if (less(x, y)) x :: merge(xs1, ys)         //x   compare heads from both lists
        else y :: merge(xs, ys1)
    }
//x                                     R E A L    M E A T
  val n = xs.length / 2

  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))     //Warn:  wow
  }
}

val abcde = List('a','b','c','d','e')

//x--One difference between the previous uses of sortWith and msort concerns the admissible syntactic forms of the comparison function
//compare
msort((x: Char, y: Char) => x > y)(abcde)
//with
abcde sortWith (_ > _)

//The two expressions are equivalent, but the first uses a longer form of comparison function with named parameters
// and explicit types whereas the second uses the concise form, (_ > _), where named parameters are replaced by underscores.

//note: the short form cannot be used with msort => To understand why, you need to know details of Scala’s type inference algorithm...

//Warn:   In a method application  m(args), the inferencer first checks whether the method m has a known type.
//Warn:   If it has, that type is used to infer the expected type of the arguments


//Warn:   msort(_ > _)(abcde)    will throw:   error: missing parameter type for expanded

//Note:   resolotion is to pass an explicit type parameter to msort:      msort[Char](_ > _)(abcde)
msort[Char](_ > _)(abcde)

val lstStr = List("as","bs","bl","ak","nn","nn","aa","bb")

"(msort[String](_ < _)(lstStr)) = " + (msort[String](_ < _)(lstStr))

//Note                                                                                                -
//Note:   Another possible solution is to rewrite the msort method so that its parameters are swapped -
//Note                                                                                                -
def msortSwapped[T](xs: List[T])(less: (T, T) => Boolean) : List[T] =
{
  msort[T](less) (xs)
}

"msortSwapped = " + (msortSwapped(lstStr)(_ > _))

//Note                                                                                                -
//Note   without additional type information its type is inferred to be a List[Nothing].              -
//Warn:     (xss :\ List()) (_ ::: _)   // this won’t compile

def flattenRight[T](xss: List[T]) =
  (xss :\ List[T]()) (_ :: _)

def flattenLeft[T](xss: List[T]) =
  (List[T]() /: xss) (_ ::: List(_))

flattenRight[String](lstStr)
flattenLeft[String](lstStr)

/*
x   16.11 Conclusion
x   Now you have seen many ways to work with lists. You have seen the basicoperations like head and tail,
x   the FIRST-ORDER OPERATIONS like REVERSE,
x   the HIGHER-ORDER operations like MAP,
x   and the utility methods in the List object.
x   Along the way, you learned a bit about how Scala’s type inference works.
x   Lists are a real work horse in Scala, so you will benefit from knowing
x   how to use them. For that reason, this chapter has delved deeply into how to
x   use lists. Lists are just one kind of collection that Scala supports, however.
 */
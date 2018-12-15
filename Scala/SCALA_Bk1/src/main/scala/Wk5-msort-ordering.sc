import math.Ordering    //x   2017/02/17


//x--using  generics and standard Orderning form Scala lib insted of Funtion for compare

def msortOrdering[T](xs: List[T])(ord: Ordering[T]): List[T] =  {
  val n = xs.length / 2

  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]):List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case(xs, Nil) => xs
      case(x :: xs1 ,  y :: ys1) =>
        if(ord.lt(x,  y))  x:: merge(xs1, ys)
        else y :: merge(xs, ys1)

    }
    val (fst, snd) = xs splitAt n
    merge (msortOrdering (fst)(ord), msortOrdering (snd)(ord) )
  }
}

//numbers
val srtNumsL = List(33,21,11,55,1,-4,44,-5)

msortOrdering(srtNumsL)(Ordering.Int)


//strings
val fruitsL = List( "apple",  "orange" , "banana","plum","lemon")
msortOrdering(fruitsL)(Ordering.String)


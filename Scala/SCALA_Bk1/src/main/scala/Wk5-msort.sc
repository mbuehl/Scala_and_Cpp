//x-- mergeSort plain solution

def msort(xs: List[Int]): List[Int] =  {
  val n = xs.length / 2

  if (n == 0) xs
  else {
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

def merge(xs: List[Int], ys: List[Int]):List[Int] = xs match {
    case Nil => ys
    case x :: xs1 => ys match {
        case Nil => xs
        case y :: ys1 =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
  }

val srtNumsL = List(33,21,11,55,1,-4,44,-5)
"Result mergeSort:  " + msort(srtNumsL)

//x---------- using  generics and Function for compare

def msort2[T](xs: List[T])(lt: (T,T) => Boolean): List[T] =  {
  val n = xs.length / 2

  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]):List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case(xs, Nil) => xs
      case(x :: xs1 ,  y :: ys1) =>
        if(lt(x,  y))  x:: merge(xs1, ys)
        else y :: merge(xs, ys1)

    }
    val (fst, snd) = xs splitAt n
    merge (msort2 (fst)(lt), msort2 (snd)(lt) )
  }
}

//numbers
msort2(srtNumsL)((x: Int, y:Int) => x < y)


//strings
val fruitsL = List( "apple",  "orange" , "banana","plum","lemon")
msort2(fruitsL)((a: String, b: String) => a.compareTo(b) < 0)


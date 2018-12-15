//x     Exercise    pack + encode
//x     --------
//x  1. Perform groupping for all consecutive duplicates
//x  2. Calc occurancies

val listToPack = List("a","a","a","b","c","c","a","j","j","j","j","j","j","j")

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil      => Nil
  case x :: xs1  =>
    val (beg, tail) = xs span (z => z == x)
    beg :: pack(tail)
}

val packedList =  pack(listToPack)


def encode[T] (xs: List[T]):List[(T,Int)] = xs match {
  case Nil      => Nil
  case x :: xs1  =>
    val (beg, tail) =  xs span(z => z == x)
    (x, beg.length) :: encode(tail)
}

val encodedlist =  encode (listToPack)

//x  .OR. much simpler using mapping and pack  Warn......G O O D.....

def encode2[T] (xs: List[T]):List[(T,Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

val encodedlist2 = encode2 (listToPack)


def decode[T] (xs: List[(T,Int)] ): List[T] = xs match {
  case Nil        => Nil
  case y :: ys    =>
//    val (elm, cnt) = y

    def loop(a: T,acc: Int): List[T] =
      if(acc == 0)  Nil
      else a :: loop(a, acc-1)

    loop(y._1, y._2) ::: decode(ys)
}

val decodedlist = decode(encode(listToPack)) +
  "  ...OK.\n  where: encoded is: " + encode(listToPack)

//x---my decoding map solution...for List((a,3), (b,1), (c,2), (a,1), (j,7))

def decodeMapUsgMapgFltn[T] (xs: List[(T,Int)] ): List[T] = {
//  xs map (elm => elm._1) //todo  still looking for it  2/24/17

  def loop(a: T, acc: Int): List[T] =   //(T, :Int) -> obtain list of T ... acc times
    if (acc == 0) Nil
    else a :: loop(a, acc - 1)
                          //todo  getting list of lists 3/19/17 ... must flatten now
  val listOfLists = xs map (elm => loop(elm._1, elm._2))
  listOfLists.flatten     //x 3/19 need to flatten... chpt: 16.6 Flattening a list of lists: flatten.
}

"\ndecode MAP Using mappig and list flatten: " + decodeMapUsgMapgFltn(encode(listToPack)) +
  "\n   Where: encoded list is: " + encode(listToPack)






















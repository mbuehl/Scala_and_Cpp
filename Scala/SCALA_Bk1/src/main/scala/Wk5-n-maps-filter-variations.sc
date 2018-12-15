//x  List Filtering is based on map definitions
abstract class Lista[T]{
//  def map[U](f: T => U): List[U] = this match {
//    case Nil      => this
//    case x :: xs  => f(x) :: map(xs)
//  }
//  //x when using pattern matching
//    def filterOut(p: T => Boolean): List[T] = this match  {
//      case Nil  => this
//      case x :: xs => if(p(x)) x :: xs.filterOut(p) else xs.filterOut(p)
//    }
//  //x when using filter
//    def filterOut(xs: List[Int] => Boolean): List[Int] =
//      xs filter (x => x > 0)
}

val lst = List (3,5,1,2,88,1,1,-1)

"xs filter:  " + (lst filter (x =>  x < 4))        + "  ok"
"xs filterNot:  " + (lst filterNot (x =>  x < 4))  + "  ok"
"xs partition:  " + (lst partition  (x =>  x < 4))  + "  ok  list filter + list FilterNot"

"xs takeWhile:  " + (lst takeWhile  (x =>  x < 6))  + "  ok  until 6 or higher elm found"
"xs dropWhile:  " + (lst dropWhile  (x =>  x < 6))  + "  ok  start after 6 or higher elm found"
"xs span:  " +  (lst.span(x =>  x < 6))  + "  ok  combine takeWhile and dropWhile Lists"


//x--filtering List elements using pattern matching ...and mapping

def posElms(xs: List[Int]): List[Int] =
  if(xs == Nil) Nil
  else if(xs.head > 1) xs.head :: posElms(xs.tail)
  else posElms(xs.tail)

//                            more concise - using matching
def posElmsPM(xs: List[Int]): List[Int] = xs match {
  case Nil      => xs
  case w  :: ws => if( w > 1 ) w :: posElmsPM(ws) else posElmsPM(ws)
}

//x                       even more concise - using list filtering
def posElmsF(xs: List[Int]) =  xs filter (x => x > 1)

"posElms:  " + posElms(lst)
"posElmsPM:  " + posElmsPM(lst)
"posElmsFilter:  " + posElmsF(lst)

//x--reversal & range with mapping
"reverse: " + lst.reverse

"range with mapping: " + List.range(1, 3) map (x => (3, x))




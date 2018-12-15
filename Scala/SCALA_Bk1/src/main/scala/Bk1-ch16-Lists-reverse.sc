//x          chpt 16 lists  reverse

//x--recursion
def reverse[t](p_in: List[t]):List[t] = {
  if(p_in == Nil)  Nil
  else            reverse(p_in.tail) ::: List(p_in.head)
 }

val lst = List(1,2,3,4,5,6,7,8,9)

val revs = reverse(lst)

//x--recursion + pattern matching

def revsMtch[t](xs: List[t]):List[t] = xs match  {
    case List() => Nil
    case a  => revsMtch(a.tail) ::: List(a.head)
}

val revsMtchV = revsMtch(lst)
val revsMtchEmptyV = revsMtch(List())

//x--recursion + pattern matching + want to throw exception when there is nothing on input

var xxx = 0
def revsMtch2[t](xs: List[t]):List[t] = xs match  {
  case List() =>  if(xxx == 0)  println("Nothing to reverse"); Nil
  case a  => xxx+=1; revsMtch2(a.tail) ::: List(a.head)
}
xxx=0
val revsMtchV2 = revsMtch2(lst)
val whatIsxxx = xxx

xxx=0
val revsMtchV2empty = revsMtch2(List())
val whatIsxxx2empty = xxx

xxx=0
val revsMtchV3 = revsMtch2(lst)
val whatIsxxx3 = xxx

//x--Book example

def rev[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case x :: xs1 => rev(xs1) ::: List(x)
}
val revBk = rev(lst)

lst.reverse.reverse == lst


lst.reverse.init == lst.tail.reverse
lst.reverse.tail == lst.init.reverse
lst.reverse.head == lst.last
lst.reverse.last == lst.head











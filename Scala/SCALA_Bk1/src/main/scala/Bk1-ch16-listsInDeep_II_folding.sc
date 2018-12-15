//x chpt 16 Lists - folding left /: and right ;\

val lsInt = List(1,2,3,4,5,6,7,8)
val lsChr = List('a','b','c','d','z')

//x--
// xs span p equals (xs takeWhile p, xs dropWhile p)
val xs = List(1, 2, 3, -4, 5)

def flattenLeft[T](xss: List[List[T]]) = (List[T]() /: xss) (_ ::: _)
def flattenRight[T](xss: List[List[T]]) = (xss :\ List[T]()) (_ ::: _)
"flattenLeft = " + flattenLeft(List(xs))
"flattenright = " + flattenRight(List(xs))

val words = List("the", "quick", "brown", "fox")
("" /: words) (_ + " " + _)
(words :\ "" ) (_ + " " + _)

//1. Assume traversing the list and calculating sum of elements
def sum(lst: List[Int]) = {
var suma = 0
lsInt foreach (suma += _)
suma
}
sum(lsInt)

//2. That can be done as one-liner -> using folding
def sumFld(xs: List[Int]): Int = (0 /: xs) (_ + _)
sumFld(lsInt)

//x--One another N o t e
//x--A fold left operation (z /: xs) (op) involves three objects: a start value z, a list xs, and
// a binary operation op. The result of the fold is op applied between successive elements
// of the list prefixed by z. For instance:
//
//x-- (z /: List(a, b, c))(op) jest rownowazne op(op(op(z, a), b), c)

("" /: words) (_ + "." + _) //x-- op to ( _ + "." + _ )
(words.head /: words.tail) (_ + "."+ _)


def reverseLeft[T](xs: List[T]) = //Note: operation(List(), x) equals List(x)
(List[T]() /: xs) { (ys , y) => y :: ys } //ys jet rownowazne List() , y jest xs, a pozniej jest element po elemencie

reverseLeft(lsChr)

//def reverseRight[T](xs: List[T]) = //Note: operation(List(), x) equals List(x)
// ( xs :\ List[T]()) { (ys , y) => y.head }
//
//reverseRight(lsChr)

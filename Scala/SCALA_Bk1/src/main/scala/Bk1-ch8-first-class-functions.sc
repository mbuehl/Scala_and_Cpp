import scala.collection.mutable
import scala.collection.mutable._

//x--Anonymous inline function `
val increase = (x: Int) => x + 1
increase(4)
//x--Anonymous inline function
val incr_d2 = (x: Int, d: Double, unt: String) => ((x + 1.9 ) * d ) *100 + unt
incr_d2(4, 0.12," %")
//same as above
val duplex = (x: Int, y: String) => x.toString + y
duplex(50, " zloty")

//x--about lists
val someNumbers = List(-11, -10, -5, 0, 1, 10)

//
someNumbers.foreach((x:Int) => print(x + " "))
//x--print out all elements increased by ...  WARN: does not effect original LIST
//x++chain few commands
someNumbers.foreach( (x:Int) => { print(x+2) ; print("  *" + x +  "*  ") }  )

//x--Test condition on ALL elements of list
val isCondMet = someNumbers.forall((x:Int) =>  x + 2 > 0 )
//X--Reverse-does
val newReversedList:List[Int] = someNumbers.reverse
//Placeholder syntax - traversing List and filtering - creating new list
val filterReversedList:List[Int] = newReversedList.filter( _ > 1)

//Partially applied functions
filterReversedList.foreach( print _   )

//x--closures - traversing List and accumulating wealth
var sum = 0
someNumbers.foreach(sum +=  _)
"accumulated sum from traversing list is ==>  "  + sum
newReversedList.filter( _ > 2).foreach((x:Int) => sum += x)
"accumulated sum from traversing 2 lists is ==>  "  + sum

//use maps for intra list conversions in place
val newList_1 = someNumbers map (x =>  x + 2)

def fn (x:Int, s:String) = x + s
val listTravesedWithFnApplied = someNumbers map (x =>  fn(x, "huha"))
val traveWithFnAppliedSpecFun = someNumbers.filter(x => x < 5 &&  x > -7).map (x =>
  fn(x, "cc"))

def matcher(x: Int): Boolean = x > 0 && x < 999
var sum2 = 0
newReversedList.foreach(x => if(matcher(x)) sum2 += x )
sum2

//Warn:  Flattening works only on List[List[...]]
val newListoFLists:List[List[Int]] = newReversedList.map(x => if(matcher(x)) List(x) else List())
newListoFLists.flatten

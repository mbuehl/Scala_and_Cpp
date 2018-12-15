import java.io.{File, PrintWriter}

//x       9.4 Writing new control structures

//In languages with first-class functions, you can effectively make new control
//structures even though the syntax of the language is fixed. All you need to
//do is create methods that take functions as arguments.

//For example, here is the “twice” control structure, which repeats an operation
//two times and returns the result:
def twice(op: Double => Double, x: Double) = op(op(x))
val xx2 =  twice(_ + 1, 5)   //Note:    op is   (_ + 1)  where _ is x

def triple(op: Double => Double, x: Double) = op(op(op(x)))
val xx3 =  triple(_ + 1, 5)   //Note:    op is   (_ + 1)  where _ is x


//Any time you find a control pattern repeated in multiple parts of your
//code, you should think about implementing it as a new control structure

def withPrintWriter(file: File, op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

//Given such a method, you can use it like this:

withPrintWriter(
  File.createTempFile("./date",".txt"), //or   val file = new File("date.txt")
  writer => writer.println(new java.util.Date)
)
//....or when using by-name control structure
//In this example, the first argument list, which contains one File argument, is
//written surrounded by parentheses. The second argument list, which contains
//  one function argument, is surrounded by curly braces.
//x   Using the loan pattern to write to a file
//x   The new version differs from the ANOVE one only in that there are now two
//x   parameter lists with one parameter each instead of one parameter list with
def withPrintWriter2lists(file: File)(op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

//9.5 By-name parameters
//Warn:   two parameters    vs.   2 parameter lists =>  call the method with a more pleasing syntax

val file = File.createTempFile("./date",".txt") //or   val file = new File("date.txt")

withPrintWriter2lists(file) {
  writer => writer.println(new java.util.Date)
}

//the first argument list, which contains one File argument, is written surrounded by parentheses.
// The second argument list, which contains one function argument, is surrounded by curly braces


//Warn:   loan pattern
//Warn:   ------------
//Warn:   This technique is called the loan pattern, because a
//Warn:   control-abstraction function, such as withPrintWriter,
//Warn:   opens a resource and “loans” it to a function.

//The purpose of this ability to substitute curly braces for parentheses for
//  passing in one argument is to enable client programmers to write function
//    literals between curly braces. This can make a method call feel more like a
//  control abstraction

//The advantage of using this method is that it’s withPrintWriter, not user
//  code, "warn" that assures the file is closed at the end !!!

//x--writing control abstractions - between curly brackets (instead of parenthessis)

val g = "Hello, world!"
val z = "1234567890abcdefghijklmnoprstuwvxyz"
val glength = g.length
val zlength = z.length


//x     This curly braces technique will work, however, if you’re passing in
//Warn: O N E   argument   O N L Y   !!!
val g_substring3 = g.substring { 3 }

val g_substringIF = g.substring { if(g.length > 4)  5 else 2 }  //control abstractions in curly b.

//x  Enable client programmers to write function literals between curly braces.
//x  This can make a method call feel more like a control abstraction

val substring2_5 =   g.substring (2)(5)
val substring2_5_curly =  g.substring {if(g.length > 4)  5 else 2} {if(g.length > 6)  7 else 4}

def fn1 = (inStr:String) => inStr.substring {if(inStr.length > 13)  13 else 0}
val fn1g = fn1(g)
val fn1z = fn1(z)

def fn2 = (inStr:String) => inStr.substring( {if(inStr.length > 15) inStr.length-3 else 1},
  {  inStr.length-1 }  )
val fn2g = fn2(g)

val fn2z = fn2(z)
val ALLz = z

def val3(ii: Integer)(ss: String):String =   { (ii + " -> " + ss.substring(0, ss.length/2)).toString() }
val val3g = val3(4)(g)
val val3z = val3(4)(z)
//val substring2_5_curly(g: String) =  g.substring {if(g.length > 4)  5 else 2} {if(g.length > 4)  8 else 4}


/*
x   by value type vs. by name type

x   1-st case eval is done right away whereas in 2-ns case only when it come to that
x   point that  function is to be called

x   e.q.
x   by-value =>  bool && bool - both are checked right away
x   by-name =>   bool && bool - 2-nd bool is checked when 1st is TRUE
*/

var assertionsEnabled = false

def byValueAssert(predicate: Boolean) =  if (assertionsEnabled && !predicate)    throw new AssertionError
def byNameAssert(predicate:() => Boolean) =  if (assertionsEnabled && !predicate())    throw new AssertionError


val byName = byNameAssert(() => 3/0 == 0) // predicate eval is done only when assertionsEnabled is TRUE (everything evald before is OK)


val byValue = byValueAssert(3/0 == 0)   // predicate eval is done right away no matter what was before


println("the end")



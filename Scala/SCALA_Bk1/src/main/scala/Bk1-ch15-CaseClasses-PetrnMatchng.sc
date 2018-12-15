//x     ch 15
//x   Case classes are Scala’s way to allow pattern matching on objects without requiring a large
//x   amount of boilerplate.  In the common case, all you need to do is add a single case keyword
//x   to each class that you want to be pattern matchable.


abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

//The hierarchy includes an abstract base class Expr with four subclasses,
// one for each kind of expression being considered
//In Scala you can leave out the braces around an empty class body if you wish,
// so class C is the same as class C {}.

//1.  Scala compiler add some syntactic conveniences to your class.

val v = Var("x")  //he factory methods are particularly nice when you nest them. Because there are no noisy new keywords
val op = BinOp("+", Number(1), v)

//2.  The second syntactic convenience is that all arguments in the parameter list of a case class implicitly
//    get a val prefix, so they are maintained as field

v.name
op.left;   op.right
//3.  Third, the compiler adds “natural” implementations of methods toString, hashCode, and equals to your class.
//    They will print, hash, and compare a whole tree consisting of the class and (recursively) all its arguments.

println("" + op)

//4.  Finally, the compiler adds a copy method to your class for making modified copies. This method is useful
//    for making a new instance of the class that is the same as another one except that one or two attributes
//    are different.

op.copy(operator = "-")

//5.  However, the biggest advantage of case classes is that they support pattern matching.


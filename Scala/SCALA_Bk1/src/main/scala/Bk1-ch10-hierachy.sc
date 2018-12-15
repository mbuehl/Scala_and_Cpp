/*x       Chpt 10.6
x
x   Generally, Scala has just two namespaces for definitions in place of Java’s
x   four. Java’s four namespaces are fields, methods, types, and packages. By
x   contrast, Scala’s two namespaces are:
x   • values (fields, methods, packages, and singleton objects)
x   • types (class and trait names)

x   The reason Scala places fields and methods into the same namespace is precisely
x   so you can override a parameterless method with a val, something
x   you can’t do with Java
*/

abstract class Element {
  def contents: Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length
}
class ArrayElement( conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}
val ae = new ArrayElement(Array("hello", "world"))
ae.width

//----- Defining parametric fields

class Cat {  val dangerous = false }
class Tiger( override val dangerous: Boolean,  private var age: Int  ) extends Cat

//x  OR .equivalently. Tiger’s definition is a shorthand for the following alternate class definition  with an overriding member dangerous and a private member age:

class Tiger2(param1: Boolean, param2: Int) extends Cat {
  override val dangerous = param1
  private var age = param2
}

//x   10.7 Invoking superclass constructors  Warn: Moge oddzielnie inicjowac Constr.class and superclass
//x   To invoke a superclass constructor, you simply place the argument or arguments you want to  pass in parentheses following the name of the superclass
//warn:    class                         superclass
class LineElement(s: String) extends ArrayElement(/*Array(s)*/Array("12121","2121") )  //Array("12121","2121"))
{
  override val width = s.length
  override val height = 1
}

val cls = new LineElement("lmdcld")
cls.width
cls.contents.mkString("  ")


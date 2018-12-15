//x   10.9 Polymorphism and dynamic binding

//The inheritance hierarchy - constructor calling sequence

abstract class Element {
  def demo() {
    println("Element's implementation invoked")
  }
}
class ArrayElement extends Element {
  override def demo() {
    println(" >> ArrayElement's implementation invoked")
  }
}
class LineElement extends ArrayElement {
  override def demo() {
    super.demo()          //warn:  invoking super.demo, then current demo
    println("LineElement's implementation invoked")
    super.demo()          //warn:  invoking super.demo, then current demo
  }
}
// UniformElement inherits Element’s demo
class UniformElement extends Element


def invokeDemo(e: Element) {
  e.demo()
}
invokeDemo(new ArrayElement)

invokeDemo(new LineElement)

invokeDemo(new UniformElement)

/*
The other half of the story, however, is that method invocations on variables
and expressions are:
x        dynamically bound.
This means that the actual method implementation invoked is determined at run time
based on the class of the object, not the type of the variable or expression
 */
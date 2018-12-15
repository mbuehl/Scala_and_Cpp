//x   10.11 Using composition and inheritance
/*
Composition and inheritance are two ways to define a new class in terms
of another existing class. If what you’re after is primarily code reuse, you
should in general prefer composition to inheritance.
Only inheritance suffers from the fragile base class problem, in which you
can inadvertently break subclasses by changing a superclass.
 */

abstract class Element {
  def contents: Array[String]
  def height = contents.length
  def width =
    if (height == 0) 0 else contents(0).length
}

//Perhaps it would be better, therefore, to define LineElement as a direct subclass of Element

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}

//It now has a composition relationship with Array: it holds a reference to an array of strings from its own contents field

// Class ArrayElement also has a composition relationship with Array, because its parametric contents
// field holds a reference to an array of strings
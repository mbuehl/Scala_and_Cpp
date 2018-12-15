//x   10.9 Polymorphism and dynamic binding

abstract class Element {
  def contents: Array[String]
  def height = contents.length
  def width =
    if (height == 0) 0 else contents(0).length
}
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}
class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts

  override def height: Int = contents.length

  override def width: Int = {
    var l_len = 0
    def max(a: Int): Int = Math.max(a, l_len)

    if (height == 0) 0 else contents.foreach(x => l_len = max(x.length))
    l_len
  }
}

class UniformElement(ch: Char,  override val width: Int, override val height: Int )
  extends Element {
                  private val line = ch.toString * width
                  def contents = Array.fill(height)(line)
                }


val e1: Element = new ArrayElement(Array("hello", "world"))
val ae: ArrayElement = new LineElement("hello")
val e2: Element = ae
//                              x elm,  width = 3 , heigh = 5 => res0: String = xxx  xxx  xxx  xxx  xxx
val e3: Element = new UniformElement('x', 3, 5)
e3.contents mkString("  ")
e3.height


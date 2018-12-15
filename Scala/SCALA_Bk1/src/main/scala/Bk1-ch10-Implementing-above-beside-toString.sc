//x   10.12 Implementing above, beside, and toString


//abstract class Element {
//  def contents: Array[String]
//  def height = contents.length
//  def width =
//    if (height == 0) 0 else contents(0).length
//}
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

//object Element {
//  def elem(contents: Array[String]): Element =
//    new ArrayElement(contents)
//  def elem(chr: Char, width: Int, height: Int): Element =
//    new UniformElement(chr, width, height)
//  def elem(line: String): Element =
//    new LineElement(line)
//}

abstract class Element {
  def contents: Array[String]

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def width: Int =
    if (height == 0) 0 else contents(0).length
  def height: Int = contents.length
  def above(that: Element): Element =
    elem(this.contents ++ that.contents)
  def beside(that: Element): Element =
    elem(
      for ((line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  override def toString = contents mkString "\n"
}

(new ArrayElement(Array("one", "two")) beside  new ArrayElement(Array("one")) )
//above
(new ArrayElement(Array("2","1")) above  new ArrayElement(Array("1", "2")) )




//Listing 10.12 · Hiding implementation with private classes.

//object Element {
//  private class ArrayElement(
//                              val contents: Array[String]
//                            ) extends Element
//  private class LineElement(s: String) extends Element {
//    val contents = Array(s)
//    override def width = s.length
//    override def height = 1
//  }
//  private class UniformElement(
//                                ch: Char,
//                                override val width: Int,
//                                override val height: Int
//                              ) extends Element {
//    private val line = ch.toString * width
//    def contents = Array.fill(height)(line)
//  }
//  def elem(contents: Array[String]): Element =
//    new ArrayElement(contents)
//  def elem(chr: Char, width: Int, height: Int): Element =
//    new UniformElement(chr, width, height)
//  def elem(line: String): Element =
//    new LineElement(line)
//}
//




object Spiral
{
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  def elem(line: String): Element =
    new LineElement(line)
//--
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Int): Element =
  {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges-1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-',  sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }
  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}

println(Spiral.spiral(15, 0))





//val column1 = elem("hello") above elem("***")
//val column2 = elem("***")
//
//column1 beside column2


//val ae = new ArrayElement(Array("hello","dummy"))

val cc = Array(1, 2, 3) zip Array("a", "b")
cc mkString ", "



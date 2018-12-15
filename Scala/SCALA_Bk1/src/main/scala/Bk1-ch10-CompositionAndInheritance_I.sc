//x   10.1 A two-dimensional layout library

//For convenience, the library will provide factory methods named “elem” that construct new elements from passed data. For
//example, you’ll be able to create a layout element containing a string using   a factory method with the following signature:

abstract class Element {
  def contents: Array[String]
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
  def height: Int = contents.length
  def width: Int = {
    var l_len = 0
    def max(a:Int):Int = Math.max(a,l_len)

    if (height == 0) 0 else  contents.foreach(x => l_len = max(x.length))
    l_len
  }

  def sum: Int = {
    var l_len = 0
    if (height == 0) 0 else contents.foreach(l_len += _.length)
    l_len
  }


  override def toString() = ( contents mkString(", ") )+ " ..." + height +"x" +
    width + "  sum: " + sum
}

val ae = new ArrayElement(Array("hello", "world","abcdefgh","123"))

println(ae)


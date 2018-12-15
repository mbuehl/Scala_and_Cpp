package ch10

/**
  * Created by Mis7desktop on 4/2/2017.
  */
import org.stairwaybook.layout.Element
import org.stairwaybook.layout.Element.elem

object Spiral_2 {

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): Element =
  {
    if (nEdges == 1)
      elem("+")
    else
    {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
//x--
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
//x--
      val doloz_No = elem("" + nEdges)        //x   adding numbers on corners to see how it progresses

      if (direction == 0)
        (doloz_No beside corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (doloz_No above corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner beside doloz_No)
      else
        (verticalBar above corner above doloz_No) beside (space above sp)
    }
  }

  def main(args: Array[String]) {
    var nSides = args(0).toInt

    if(nSides < 5) nSides = 10

    println(spiral(nSides, 0))
  }
}

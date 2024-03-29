package ch10

/**
  * Created by Mis7desktop on 4/2/2017.
  */

object MergeSort_WithProgressInd {

  var ind = 0

  def mrgSrt(lst: List[Int]) : List[Int] =
  {
    val half = lst.length/2

    if(half == 0)  lst
    else merge(mrgSrt(lst.splitAt(half)._1), mrgSrt(lst.splitAt(half)._2))
  }

  def merge(a: List[Int], b: List[Int]) : List[Int] =
  {
    ind += 1
    if(a.length == 0 ) b
    else if (b.length == 0 ) a
    else {
      if(a.head > b.head)  b.head :: merge(a,  b.tail)
      else a.head :: merge(a.tail,  b)
    }
  }



  def main[T](xx: Array[String]) {
    //val arg1 = xx(0).toInt

    val inp = List(1,5,4,3,4,5,3,11,999,1,-444,-11,0,0,1)


    println(inp + "\n\n"+ mrgSrt(inp)+"\t\t" + ind)
  }
}

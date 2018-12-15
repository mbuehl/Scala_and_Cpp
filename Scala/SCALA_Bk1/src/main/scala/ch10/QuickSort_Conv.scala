package ch10

/**
  * Created by Mis7desktop on 4/5/2017.
  */
object QuickSort_Conv
{
  var cnt = 0

  def sort(xs: Array[Int])  {
    def swap(i: Int, j: Int) {
      val t = xs(i); xs(i) = xs(j); xs(j) = t
    }
    def sort1(l: Int, r: Int)
    {
      cnt += 1

      val pivot = xs((l + r) / 2)
      var i = l; var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }
    sort1(0, xs.length - 1)
  }

  def main[T](xx: Array[String]) {
    //val arg1 = xx(0).toInt

    var arr = Array(1,5,4,3,4,5,3,11,999,1,-444,-11,0,0,1)

    sort(arr)
    println(arr  mkString(" ") )
    println("Count: "+cnt+"\n\n")

    val a = Array(5, 3, 2, 2, 1, 1, 9, 39 ,219, 1)
    sort(a)
    a.foreach(n=> (print(n), print (" " )))
    println("\nCount: "+cnt+"\n\n")


    val z = a.length
    val pivot = a (a.length / 2)
    println( a mkString (" ") )
    println( "pivot val = " + pivot + "  a.length = " + a.length+ "  a.length /2 = " + a.length/2 )

  }


}

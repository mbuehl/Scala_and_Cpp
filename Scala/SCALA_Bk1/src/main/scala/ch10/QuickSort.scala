package ch10

/**
  * Created by Mis7desktop on 4/2/2017.
  */

object QuickSort {

  var cnt = 0

  /* Quicksort in Scala */
  def sort(a: Array[Int]): Array[Int] = {
     cnt += 1

    if (a.length < 2) a
    else
    {                               //Note: a(a.length / 2)  is equivalent for:  a[a.length / 2]
      val pivot = a(a.length / 2)
                                    //Note:   sort(a filter (pivot < )  is the same as:   sort(a filter (y => pivot < y)
      sort(a filter (pivot >)) ++ (a filter (pivot ==)) ++ sort(a filter (x => pivot < x))
    }
  }


  def main[T](xx: Array[String]) {
    //val arg1 = xx(0).toInt

    println(sort(Array(1,5,4,3,4,5,3,11,999,1,-444,-11,0,0,1)) mkString (" ") )
    println("Count: "+cnt+"\n\n")

    val a = Array(5, 3, 2, 2, 1, 1, 9, 39 ,219)
    sort(a).foreach(n=> (print(n), print (" " )))
    println("\nCount: "+cnt+"\n\n")


    val z = a.length
    val pivot = a (a.length / 2)
    println("a = " + a.toString + "    z = " + z + "   pivot = " + pivot)
  }


//vogella
//  object Test {
//    def main(args: Array[String]) = {
//      val quicksort = new Quicksort
//      val a = Array(5, 3, 2, 2, 1, 1, 9, 39 ,219)
//      quicksort.sort(a).foreach(n=> (print(n), print (" " )))
//
//    }
//}


}

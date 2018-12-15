//x   Two ways for defining square lists                 2017/02/18


//x--1. when using pattern machhing
def squareList1(xs: List[Int]): List[Int] =
xs match {
  case Nil => Nil
  case y :: ys =>  y*y :: squareList1(ys)
}

//x--2. when using mapping
def squareList2(xs: List[Int]): List[Int] =
xs map (g => g*g)                       //  (x => x*x)


val nums = List(3,4,-2,-32,1,0,90)

"1. WHEN Using pattern matching: "+squareList1(nums).sorted
"2. WHEN Using mapping: "+squareList2(nums).sortWith((x,y) => x > y)


val lst = List (3,5,1,2,88,1,1,-1)

//x--scaling List elements using mapping

def scaleList (xs: List[Double], scaleFactor: Double) =
xs map (x => x * scaleFactor)

                    //x ..and additionaly mapping Int to Double on-the-fly
val scaledList = scaleList(lst.map( x => x.toDouble ), 3.0)






//Warn:   using mapping is more concise then pattern matching with recursion


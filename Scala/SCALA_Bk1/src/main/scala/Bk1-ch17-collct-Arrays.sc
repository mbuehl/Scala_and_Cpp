//x   Ch17 - Arrays
//  Arrays allow you to hold a sequence of elements and efficiently access an element at
//  an arbitrary position, both to get or update the element, with a zero-based index
//  you can seamlessly use existing Java methods that return arrays
//  Scala by placing an index in PARENTHESES, not square BRACKETS as in Java

val fiveInts = new Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)

fiveInts(1) = fiveToOne(3)    //init for el(1)   ...not el[1]

fiveInts mkString(", ")

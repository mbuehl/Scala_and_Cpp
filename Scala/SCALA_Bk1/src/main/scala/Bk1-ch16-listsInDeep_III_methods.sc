//x   16.7 The operation xs sortWith before, where “xs” is a list and “before” is a function that can be used to compare two elements, sorts the elements of list xs.

val words = List("the", "quick", "brown", "fox")

List(1, -3, 4, 2, 6) sortWith (_ < _)
                          //Note: that sortWith performs a merge sort similar to the msort algorithm
words sortWith (_.length > _.length)

//x   16.8 Methods of the List object

//Creating lists from their elements Note:   List.apply(1, 2, 3)  jest rownowazne do   List(1, 2, 3)

//x--Creating a range of numbers: List.range
//      from, to, by
List.range(1, 5)
List.range(1, 9, 2)
List.range(9, 1, -3)

//x--Creating uniform lists: List.fill

List.fill(5)('a')
List.fill(3)("hello")
List.fill(2, 3)('b')
List.fill(2, 4)("wo")

//x--Tabulating:  List.tabulate => method creates a list whose elements are computed according to a supplied function.

val squares = List.tabulate(5)(n => n * n)
val multiplication = List.tabulate(3,3)(_ * _)

//x--Concatenating multiple lists: List.concat

List.concat(List('a', 'b'), List('c'))
List.concat(List(), List('b'), List('c'))
List.concat()

//x   16.9 Processing multiple lists together

//x--The zipped method on tuples generalizes several common operations to work on multiple lists instead of just one

//One such operation is map

(List(10, 20), List(3, 4, 5)).zipped.map(_ * _)

//x--forall:  KIEDY dlugosci z 1-wszej sa rowne numerom z drugiej listy
"(List(\"abc\", \"de\"), List(3, 2)).zipped.forall(_.length == _) => "+((List("abc", "de"), List(3, 2)).zipped.forall(_.length == _))

//x--exists:  KIEDY jest taki przypadek ze dlugosci z 1-wszej NIE sa rowne numerom z drugiej listy
"(List(\"abc\", \"de\"), List(3, 2)).zipped.exists(_.length != _) => " + ((List("abc", "de"), List(3, 2)).zipped.exists(_.length != _))


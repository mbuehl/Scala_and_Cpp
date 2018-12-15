//x   16.6  List common operations [defined in class]

val abcde = List('a', 'b', 'c', 'd', 'e')
"last =  "+ abcde.last
"init =  "+ abcde.init
"head =  "+ abcde.head
"tail =  "+ abcde.tail

//x   Prefixes and suffixes: drop, take, and splitAt
val xs = List('a','b','c','d','e','f')

val n = 3
xs splitAt n equals (xs take n, xs drop n)

"abcde take 2 =  " + (abcde take 2)
"abcde drop 2 =  " + (abcde drop 2)

"abcde split at  2 =  " + (abcde splitAt  2)

//x   Element selection: apply and indices    Warn  rare in Sca;a

"abcde apply 2 = "  + (abcde apply 2)

"abcde.indices = " + (abcde.indices)

//x   Flattening a list of lists: flatten
//WARN: It can only be applied to lists whose elements are all lists.

List(List(1, 2), List(3), List(), List(4, 5)).flatten

val fruit = "apples" :: ("oranges" :: ("pears" :: ("bubu" :: Nil)))
fruit.map(_.toCharArray)
fruit.map(_.toCharArray).flatten

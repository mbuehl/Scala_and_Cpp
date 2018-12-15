//x   17.2 Sets and maps    By default when you write “Set” or “Map” you get an  I M M U T A B L E  object.
//  If you want to use both mutable and immutable sets or maps in the same  source file, one approach is to import
//  the name of the package that contains  the mutable variants:  import scala.collection.mutable

import scala.collection.mutable

val mutaSet = mutable.Set(1,2,3)

val text = "See Spot run. Run, Spot. Run!"

val wordsArray = text.split("[ !,.]+")


val words = mutable.Set.empty[String]

for (word <- wordsArray)
  words += word.toLowerCase

//Set:    scala.collection.mutable.Set[String] = Set(see, run, spot)
words

//x   pair with element position in set
words map (x =>  words.toList.indexOf(x.toLowerCase))
//touples wrapped in List each:   Set(List(2, SPOT), List(0, SEE), List(1, RUN))
val wordsMapped = words map (x =>  List(words.toList.indexOf(x.toLowerCase), x.toUpperCase))
//flatten:   List[Any] = List(2, SPOT, 0, SEE, 1, RUN)
val words2Lst = wordsMapped.toList flatten

/*
x   Table 17.1  C O M M O N    O P E R A T I O N S     F O R    S E T S
x
x What it is                      What it does
x-----------------------------------------------
x val nums = Set(1, 2, 3)     Creates an immutable set  (nums.toString returns Set(1, 2, 3))
x nums + 5                    Adds an element (returns  Set(1, 2, 3, 5))
x nums - 3                    Removes an element (returns Set(1, 2))
x nums ++ List(5, 6)          Adds multiple elements (returns x Set(1, 2, 3, 5, 6))
x nums List(1, 2)             Removes multiple elements (returns Set(3))
x nums & Set(1, 3, 5, 7)      Takes the intersection of two sets (returns  Set(1, 3))
x nums.size                   Returns the size of the set (returns 3)
x nums.contains(3)            Checks for inclusion (returns true)
x
x import scala.collection.mutable     Makes the mutable collections easy to access
x
x val words =  mutable.Set.empty[String]   Creates an empty, mutable set  (words.toString returns Set())
x words +=                    "the" Adds an element (words.toString returns Set(the))
x words -=                    "the" Removes an element, if it exists  (words.toString returns Set())
x words ++= List("do", "re", "mi") Adds multiple elements (words.toString returns Set(do, re, mi))
x words --= List("do", "re")  Removes multiple elements (words.toString returns Set(mi))
x words.clear                 Removes all elements (words.toString  returns Set())
*/










//x   Map::   Using a map looks similar to using an array, except that instead of
//x   indexing with integers counting from 0, you can use any kind of key

val map = mutable.Map.empty[String, Int]

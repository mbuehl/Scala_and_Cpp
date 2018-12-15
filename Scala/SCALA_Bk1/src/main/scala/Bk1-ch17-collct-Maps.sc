//x   ch17   Collections    M a p s
//Using a map looks similar to using an array, except that instead of indexing with integers counting from 0, you can use any kind of key.

import scala.collection.immutable.TreeSet
import scala.collection.mutable

val mp = mutable.Map.empty[String, Int]

mp += "hello" -> 1
mp += "i" -> 1
mp -= "hellowww"
mp += ("iii" ->3, "v" ->5)

mp ++= List("ii" -> 2, "iv" -> 4,"v" -> 5)
mp --= List("iii", "v")

mp mkString("Wynik 1: ",",","  /> Size: "+ mp.size)


def countWords(text: String) =
{
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+"))
  {
    val word = rawWord.toLowerCase
    val oldCount =  if (counts.contains(word)) counts(word)
                    else 0
    counts += (word -> (oldCount + 1))
  }
  counts
}

countWords("See Spot run! Run, Spot. Run!")

//x   TreeMap     Warn: init.empty  must be by   TreeMap.empty[String, Int]

var tmap = mutable.TreeMap.empty[String, Int]
tmap ++= mp

tmap -= "i"

tmap --= List("i","ii")

//x  if you want to initialize a collection with another collection.  you’ll need to create
//x  an empty TreeSet[String] and add to it the elements of the list with the TreeSet’s ++ operator
//
val tsetIni = TreeSet[String]() ++ mp.keySet


/*
x   Table 17.2  C O M M O N    O P E R A T I O N S     F O R    M A P S
x
x What it is                            What it does
x---------------------------------------------------------
x
x val nums = Map("i" ->1, "ii" ->2)     Creates an immutable map(nums.toString returns Map(i ->1, ii ->2))
x xnums + ("vi" ->6)                    Adds an entry (returns Map(i -> 1, ii ->2, vi ->6))
x nums -"ii"                            Removes an entry (returns Map(i ->1))
x nums ++ List("iii" ->3, "v" ->5)      Adds multiple entries (returns Map(i ->1, ii -> 2, iii ->3, v ->5))
x nums --List("i", "ii")                Removes multiple entries (returns Map())
x nums.size                             Returns the size of the map (returns 2)
x nums.contains("ii")                   Checks for inclusion (returns true)
x nums("ii")                            Retrieves the value at a specified key

x nums.keys                             Returns the keys (returns an Iteratable over the strings "i" and "ii")
x nums.keySet                           Returns the keys as a set (returns Set(i, ii))
x nums.values                           Returns the values (returns an Iterable over the integers 1 and 2)
x nums.isEmpty                          Indicates whether the map is empty (returns false)
x
x import scala.collection.mutable Makes the mutable collections easy to access
x
x val words = mutable.Map.empty[String, Int]  Creates an EMPTY, mutable map
x words += ("one" -> 1)                 Adds a map entry from "one" to 1
x                                       (words.toString  returns  Map(one -> 1))

x words -= "one"                        Removes a map entry, if it exists
x                                       (words.toString returns Map())
x words ++= List("one" -> 1, "two" -> 2, "three" -> 3)            Adds multiple map entries
x                                       (words.toString returns Map(one ->1, two -> 2, three -> 3))
x words -= List("one", "two")            Removes multiple objects
x                                       (words.toString returns Map(three -> 3))

*/
/*x                 Wk6:  IO and Mappings                        */
import scala.io.Source


/** A word is simply a `String`. */
type Word = String
type ^^ = (Int,  String)

val z1: ^^ = (70, "slow")
val z2: ^^ = (29, " motion")
def +^ (x1: ^^, x2: ^^): ^^ = (x1._1 + x2._1, x1._2 + x2._2)
+^(z1,  z2)

//----URL---working-----------------------------------------------------------------------------
//val inURL = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
//val wordsSpec = inURL.getLines().toSet filter (x => x.contains("-"))

//----File--working for absolute paths----------------------------------------------------------
val in = Source.fromFile("C:/Courses/Functional Programming Principles in Scala/Week 6/forcomp/src/main/resources/forcomp/linuxwords.txt")
//
val dict = in.getLines().toList
//  //                                filtering out all the words with '-'
val words = dict filter (word => word forall (chr => chr.isLetter))
"words.len  = " + words.length

//val lstW = List("abbba","ko-ko","bubu","yast-")   try it out with plain list
val wordsSpec = dict filter (x => x.contains("-"))
"wordsSpecial.len[" + wordsSpec.size + "] " + wordsSpec

val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val strCode: Map[String, Char] =
  for ((digit, str) <- mnem) yield str -> digit

val strCodeMy1: List[String] =
  (for ((digit, str) <- mnem) yield str).toList.sorted

//val strCodeMy2: List[String] =
//  for ((digit, str) <- mnem)
//    for (i <- 0 until digit;)
////        x => x :: str yield x
//


val charCode: Map[Char, Char] =
  for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
//   entry into pair (digit, str)  then   str (part) into ltr(letter)


//word to code

def wordCode(word: String): String =
  word.toUpperCase map charCode

"Java word to code:  " + wordCode("Java")


/*x                 Wk6:  Mapping Phone keyboard into                        */
import scala.io.Source



//  val dictionaryPath = List("forcomp", "linuxwords.txt")
  /** A word is simply a `String`. */
  type Word = String
//  val dictionary: List[Word] = loadDictionary

  //val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
//
  val in = Source.fromFile("C:/Dev/Scala_Plain/src/linuxwords.txt")
//
//  //                                filtering out all the words with '-'
  val words = in.getLines().toList filter (word => word forall (chr => chr.isLetter))
//  val wordsDgt = dictionary filter (word => word exists (chr => chr.isDigit))

//  val words = dictionary filter (word => word forall (chr => chr.isLetter))

  "words.len = " + words.length
//  "wordsDgt.len = " + words.length

  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  val strCode: Map[String, Char] = for ((digit, str) <- mnem) yield str -> digit

  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
  //   entry into pair (digit, str)  then   str (part) into ltr(letter)

  //word to code

  def wordCode(word: String): String =
    word.toUpperCase map charCode

  "Java word to code:  " + wordCode("Java")
//
//  //Code to words
//  // a map from digit strings to words that represent them,
//  //e.g  5282 -> List("Java","kata","lava",...)
//  //Note: missing number like 1111 should generate  List()

//  val wordsForNum: Map[String, Seq[String]] =
//  words groupBy wordCode

  val wordsForNum: Map[String, Seq[String]] =
  words /*slice(0 , 100)*/ groupBy wordCode  withDefaultValue Seq()

/**  Return all the ways to encode number as a list of words*/
def encode(number: String): Set[List[String]] =
  if(number.isEmpty) Set(List())
  else {
    for{
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet

"encode(\"7225247386\"):  "+ encode("7225247386")

//removing commas from within
def translate (number: String): Set[String] =
  encode(number) map(_ mkString " ")

"translate(\"7225247386\"): " + translate("7225247386")



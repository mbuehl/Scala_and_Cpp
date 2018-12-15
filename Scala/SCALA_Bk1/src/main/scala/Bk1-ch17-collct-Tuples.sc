import scala.collection.mutable

//x   17.5 Tuples   a tuple combines a fixed number of items together so that they can be passed around as a whole

def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if (words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  (word, idx)
}

val longest = longestWord("The quick brown fox".split(" "))

//----------------------------------------------------

def longestWords(words: Array[String]) = {
  var wordTMap = mutable.TreeMap.empty[Int, String]
  var idx = 0
  for (i <- 0 until words.length) {
    wordTMap +=  idx + words(i).length -> words(i)
    idx += 1000
  }
  wordTMap
}

longestWords("The quick brown fox".split(" ")) mkString("\n  ","\n  ","")

"The quick brown fox".split(" ") mkString(",")


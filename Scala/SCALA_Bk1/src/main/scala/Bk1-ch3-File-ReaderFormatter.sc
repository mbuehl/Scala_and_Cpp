import scala.io.Source

val path = "C:/Dev/DEV31/SCALA_Bk1/src/main/resources"

val args = Array(path + "/linuxwords.txt", "end").toList

def widthOfLength(s: String) = s.length.toString.length

if (args.length > 0)
{
  val lines = Source.fromFile(args(0)).getLines().toList
  val longestLine = lines.reduceLeft( (a, b) => if (a.length > b.length) a else b )

  println("** longestLine    : " + longestLine + "\n")

  val maxWidth4Col1 = widthOfLength(longestLine)
  println("** maxWidth for Col1 : " + maxWidth4Col1 + "\n")

  for (line <- lines) {
    val numSpaces = maxWidth4Col1 - widthOfLength(line)
    val padding = " " * numSpaces
    println(" " + padding + line.length + " | " + line)
  }

}
else
  Console.err.println("Please enter filename")
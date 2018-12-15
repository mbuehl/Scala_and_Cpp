//x   8.2 Local functions     - like provate methods in Java    2017-03-18


import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }
  private def processLine(filename: String,
                          width: Int, line: String) {
    if (line.length > width)
      println(filename +": "+ line.trim)
  }
}
//x To use LongLines from the command line....                           ***
object FindLongLines
{
  def main(args: Array[String])
  {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}

FindLongLines.main(Array("45", "C:\\Dev\\DEV31\\SCALA_Bk1\\src\\main\\scala\\Bk1-ch8-local-functions.sc"))


def processFile(filename: String, width: Int) {
  def processLine(filename: String, width: Int, line: String) { //local function
    if (line.length > width)
      println(filename +": "+ line)
  }
  val source = Source.fromFile(filename)
  for (line <- source.getLines()) {
    processLine(filename, width, line)
  }
}
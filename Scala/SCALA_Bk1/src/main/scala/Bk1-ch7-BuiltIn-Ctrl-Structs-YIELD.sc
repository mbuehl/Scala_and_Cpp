/*x       Y I E L D                                     2017-03-10

x   Producing a new collection
x   While all of the examples so far have operated on the iterated values and then
x   forgotten them, you can also generate a value to remember for each iteration.
x   To do so, you prefix the body of the for expression by the keyword yield.

*/
val path = "C:/Dev/DEV31/SCALA_Bk1/src/main/scala"

val filesHere = (new java.io.File(path)).listFiles
for (file <- filesHere)
  println(file)

for (i <- 1 to 8) yield "Iteration " + i //x    produces Vector

val fl = new java.io.File(path)
"Root Path:  " + fl.getAbsolutePath

val filesHere2 = fl.listFiles
def fileLines(file: java.io.File) =
scala.io.Source.fromFile(file).getLines().toList


println("QQQQQQQQQQQQQQQQQQQQQQQQ")
def grepPatternRegExpr2(pattern: String) = {
  for  {
    file <- filesHere2
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
    if line exists (x => x.isSpaceChar)
    if line exists (x => x.equals('*'))
  } yield file.getName + "  " + trimmed + "  len: " + file.length()
}

grepPatternRegExpr2(".*Scala.*").toList  mkString("\n","\n","\n")

println("xxxxxxxxxxxxxxxxxxxxxxxxxx")
def grepPatternRegExpr3(pattern: String) = {
  def curriedSum(x: Int)(y: Int) = x + y

  var i:Int = 0
  for  {
//    i +=  1
    file <- filesHere2

    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
    if line exists (x => x.isSpaceChar)
  }
    yield (i).toString  + " " + file.getName + "  " + trimmed + "  len: " + file.length()
}

grepPatternRegExpr3(".*Scala.*").toList  mkString("\n","\n","\n")


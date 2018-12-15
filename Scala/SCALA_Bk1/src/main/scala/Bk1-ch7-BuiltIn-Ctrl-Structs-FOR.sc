/*
x   7.3 For expressions   2017/03/09

Scala’s for expression is a Swiss army knife of iteration. It lets you combine
a few simple ingredients in different ways to express a wide variety of iterations.
Simple uses enable common tasks such as iterating through a sequence
of integers. More advanced expressions can iterate over multiple collections
of different kinds, can filter out elements based on arbitrary conditions, and
can produce new collections.

x   Iteration through collections
*/

val path = "C:/Dev/DEV31/SCALA_Bk1/src/main/scala"


val filesHere = (new java.io.File(path)).listFiles
for (file <- filesHere)
  println(file)

//ranges
for (i <- 1 until 4)
  println("Iteration " + i)

for (i <- 1 to 4)
  println("Iteration " + i)

for (i <- 1 to 8) yield "Iteration " + i //x    produces Vector

//
//x--           **    Equivalency   **

//
val fl = new java.io.File(path)
"Root Path:  " + fl.getAbsolutePath

val filesHere2 = fl.listFiles
for (file <- filesHere2 if file.getName.endsWith(".sc"))
  println(file)

for (file <- filesHere2)
  if (file.getName.endsWith(".sc"))
    println(file)

//using   yield
for (file <- filesHere2
     if file.isFile
     if file.getName.endsWith(".sc")
) yield file

//x--Listing 7.8 · Using multiple generators in a for expression  for with '('
def fileLines(file: java.io.File) =
scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for (
    file <- filesHere2
    if file.getName.endsWith(".sc");

    line <- fileLines(file)
    if line.trim.matches(pattern)
  ) println(file + ": " + line.trim)

grep(".*val.*")

//x------------------------------------------------------------------------
println("xxxxxxxxxxxxxxxxxxxxxxxx")
val forLineLengths =
  for {
    file <- filesHere2
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(".*while.*")

  } println(trimmed.length + "  " + trimmed)

println("yyyyyyyyyyyyyyyyyyyyyyy")

def grepPatternRegExpr(pattern: String) = {
  for
  {
    file <- filesHere2
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
    if line exists (x => x.isSpaceChar)
    if line exists (x => x.equals('*'))
  } println(file.getName + "  " + trimmed)
}
grepPatternRegExpr(".*Scala.*")

println("QQQQQQQQQQQQQQQQQQQQQQQQ")
def grepPatternRegExpr2(pattern: String) = {
  for
  {
    file <- filesHere2
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
    if line exists (x => x.isSpaceChar)
    if line exists (x => x.equals('*'))
  } yield file.getName + "  " + trimmed
}

//} yield line    // yield (file + "::: => " + trimmed)

grepPatternRegExpr2(".*Scala.*").toList mkString("\n")

println("zzzzzzzzzzzzzzzzzzzzzzz")
def grepLengths(pattern: String) =
  for {
    file <- filesHere2
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } yield trimmed.length

grepLengths(".*while.*").toList

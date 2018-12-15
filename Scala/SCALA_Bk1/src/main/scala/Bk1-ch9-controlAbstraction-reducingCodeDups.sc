//x     9.1 Reducing code duplication
//One benefit of higher-order functions is they enable you to create control abstractions
//that allow you to reduce code duplication.

object FileMatcher {
  private def filesHere =
    (new java.io.File(".")).listFiles
    println(new java.io.File(".").getAbsolutePath)

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

//x--generalization - using helper - function: fnMatcher as dynamic
  def filesMatching(query: String, fnMatcher: (String, String) => Boolean) = {
    for (file <- filesHere; if fnMatcher(file.getName, query))
      yield file
  }
}
FileMatcher.filesContaining("s").toList

FileMatcher.filesMatching("rc", ((x, y) => x.contains(y)  )).toList

//x-- Using closures to reduce code duplication.
object FM_UsngClosures2reduceCodeDups {
  private def filesHere = (new java.io.File(".")).listFiles
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}


FM_UsngClosures2reduceCodeDups.filesRegex(".*").toList mkString("\n")


//x--9.2 Simplifying client code

def containsOdd(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num % 2 == 1) exists = true
  exists
}

def containsOdd4Short(nums: List[Int]): Boolean = nums exists( _ % 2 == 1)

val numL = List(32,12,22,212,110,0)

val numLcontinsOdd = containsOdd(numL)

val numLcontinsOdd4Short = containsOdd4Short(numL)




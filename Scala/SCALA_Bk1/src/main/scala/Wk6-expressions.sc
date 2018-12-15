/*x               post Wk6:  Expressions                        */

//val firstArg = match {
//  case "salt" => println("pepper")
//  case "chips" => println("salsa")
//  case "eggs" => println("bacon")
//  case _ => println("huh?")
//}

val filesHere = (new java.io.File("c:/dev/Scala_Plain")).listFiles
  for (file <- filesHere
    if file.getName.endsWith(".pdf"))
      println(file)


def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList


def grep(p_patrn: String) =
for {
    file <- filesHere

    if file.getName.endsWith("*.sc")

    line <- fileLines(file)

    trimmed = line.trim

    if trimmed.matches(p_patrn)
}  println(file + ": "+ trimmed)

grep("*.txt")


//Scala’s match expression lets you select from a number of alternatives, just
//like switch statements in other languages

type int = Int

val args = Array("1","eggs","salt")

val firstArg = if (args.length > 0) args(1) else ""

val friend = firstArg match {
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}
//print ("printing firstArg: " + firstArg + "   " + args(1))


def firstArgX(descr :String, firstArg :String): (String, String) = {

  val ret = firstArg  match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
  (descr, ret)
}

val argLen = args.length

var CC = ""
for(i <- 0 to args.length -1 ) {
  CC += i + " -> " + args(i) + ", "
}
val ccVal = CC mkString("* ","."," x")

val d2 = firstArgX(descr = "* named parameter - description: ", firstArg = "salt")

print(d2._1, d2._2)



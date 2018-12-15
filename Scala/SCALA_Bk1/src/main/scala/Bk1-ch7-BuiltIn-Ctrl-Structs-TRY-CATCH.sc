//x   The syntax for catch clauses was chosen for its consistency with an important
//x   part of Scala:  pattern matching
//
import java.io.{File, FileNotFoundException, FileReader, IOException}

var f:FileReader = null
try{
  f = new FileReader("input.txt")

  // Use  file
} catch {
  case ex: FileNotFoundException => println("Err.Msg: File Not found")
  case ex: IOException => println("IO Exception")
}
finally {
  if(f != null)    f.close()
}

//x-------  Throwing an exception looks the same as in Java.
val n = 4

val half =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")

//x-------  A catch clause that yields a value
import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
  try {
    new URL(path)
  } catch
    {
    case e: MalformedURLException =>
      new URL("http://www.scalalang.org")
    }

urlFor("http://ebuehl.com")

//Warn:  Both of these functions exhibit behavior that could surprise most programmers,
//Warn:  thus it’s usually best to avoid returning values from finally clauses.
//Warn:  The best way to think of finally clauses is as a way to ensure some side effect happens,
//Warn:  such as closing an open file

def g(): Int = try { 1 } finally { 2 }

"!! finally clauses is as a way to ensure some side effect happens:  returns 1 not 2 " + g()
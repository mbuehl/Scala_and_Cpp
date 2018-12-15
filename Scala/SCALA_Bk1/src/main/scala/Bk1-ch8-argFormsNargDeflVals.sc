import java.io.{ByteArrayOutputStream, PrintStream, PrintWriter, StringWriter}
import java.nio.charset.StandardCharsets

import scala.collection.mutable

//x--8.8 Special function call forms
def echo(args: String*) =   for (arg <- args) print(arg + " ")


val arr = Array("What's", "up", "doc?")

//Warn:  'arr: _*' This notation tells the compiler to pass each element of arr as its own argu- ment to echo, rather than all of it as a single argument.
val passArrayOfVarLen = echo(arr: _*)

val polaczone = echo ( "raz","dwa" )

def concat(args: String*):String = {
  var buf = new mutable.StringBuilder()
  for (arg <- args) buf.append(arg).append(" ")
  buf.toString() +" ..."
}

val polaczAndRetStr = concat ( "raz","dwa" ,"trzy")

//x--8.8 Defaults for function arguments

def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = "+ System.currentTimeMillis())

printTime()

// changing arg defaults and using arg naming
def printTime2(out: java.io.PrintStream = Console.out,
       divisor: Int = 1) =  out.println("time = "+ System.currentTimeMillis() / divisor)

val Time2 = printTime2( divisor = 1000)

//x    From PrintStream with extra Java conversion to String using prntStream On Baos
val baos = new ByteArrayOutputStream();
val custPrntStreamOnBaos = new PrintStream(baos);
printTime2 (out = custPrntStreamOnBaos )
val strContent = new String(baos.toByteArray(), StandardCharsets.UTF_8);





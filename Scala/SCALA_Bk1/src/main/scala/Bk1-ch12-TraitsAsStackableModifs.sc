//x   12.5 Traits as stackable modifications
//
abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue
{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

val qq = new BasicIntQueue
qq put(1); qq put(2); qq put(4)

qq get()  ;  qq get()

//Warn:   https://tersesystems.com/2012/12/27/error-handling-in-scala/     <<-  G O O D   T O U C H

import scala.util.Try
val x = Try(qq get).recover {case x => " * no more elements * "}.get
val int3:Int = x.asInstanceOf[Int]

trait Doubling extends IntQueue {  abstract override def put(x: Int) { super.put(2 * x)  }    }
trait Incrementing extends IntQueue  { abstract override def put(x: Int) { super.put(x + 1) }  }
trait Filtering extends IntQueue {  abstract override def put(x: Int) {  if (x >= 0) super.put(x)   }   }

//Warn:  Applied sequence                3          2                 1
val queue = (new BasicIntQueue with Doubling with Incrementing with Filtering )
queue.put(10); queue.put(-15); queue.put(21)

queue.get(); queue.get();     //22 44

//Warn:  Applied sequence                3                2             1
val queue2 = (new BasicIntQueue with Incrementing with Filtering with Doubling  )
queue2.put(10); queue2.put(-15); queue2.put(21)

//  For 10 :  20 -> ok -> 21
//  For 21 :  42 -> ok -> 43
queue2.get(); queue2.get();

val queue3 = (new BasicIntQueue with  Filtering with Doubling  with Incrementing)
queue3.put(10); queue3.put(-1); queue3.put(21)

//queue3.get(); queue3.get(); queue3.get();
try
{
  for(line <- Iterator.continually(queue3.get()).takeWhile(_ != null))   //or   _ != 44))
  {
    println(line)
  }
}catch {
  case e:Exception => e.printStackTrace()
}
finally {
  println("Done!")
}


/*
try {
  try {
    for (line <- Iterator.continually(input.readLine()).takeWhile(_ != null)) {
      Console.println(line)
    }
  } finally {
    input.close()
  }
} catch {
  case e:IOException => errorHandler(e)
}
*/


/*
Overall, code written in this style gives you a great deal of flexibility. You can define (x) 16 different
classes by mixing in these three traits in different combinations and orders.
That’s a lot of flexibility for a small amount of code, so you should keep your eyes open for opportunities
to arrange code as stackable modifications.
*/






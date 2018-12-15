//x   12.5 Traits as stackable modifications
//
//  Traits let you modify the methods of a class, and they do so
//  in a way that allows you to stack those modifications with each other.
//
//  As an example, consider stacking modifications to a queue of integers.
//
//The queue will have two operations: put, and get,

abstract class IntQueue {
  def get(): Int
  def put(x: Int):IntQueue
  def put2(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue
{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int):IntQueue = { buf += x ; this}

  def put2(x: Int) { buf += x }
}

val qq = new BasicIntQueue
qq put(1) put(2) put(3)

qq get()
qq get()

//Warn:   https://tersesystems.com/2012/12/27/error-handling-in-scala/

import scala.util.Try

val x = Try(qq get).recover {case x => "no more elements"}.get
val int3:Int = x.asInstanceOf[Int]
val vl4 = Try(qq get).recover {case x => "no more elements"}

throw new Error ("last of empty list" )

/*
x   Given a class that implements such a queue, you could define traits to perform modifications such as these:
x     • Doubling: double all integers that are put in the queue
x     • Incrementing: increment all integers that are put in the queue
x     • Filtering: filter out negative integers from a queue
x   These three traits represent modifications, because they modify the behavior of an underlying queue class
x   rather than defining a full queue class themselves.
x   The three are also stackable. You can select any of the three you like, mix them into a class,
x   and obtain a new class that has all of the modifications you chose.
 */
trait Doubling extends IntQueue {
  abstract override def put(x: Int):IntQueue = { super.put(2 * x); this}
  abstract override def put2(x: Int) { super.put(2 * x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

val pp = new MyQueue
pp put(11) put(50)

pp get()
pp get()
//pp get()

//x   Listing 12.10: Stackable modification traits Incrementing and Filtering.
trait Incrementing extends IntQueue {
  abstract override def put(x: Int):IntQueue = { super.put(x + 1); this }
  abstract override def put2(x: Int) { super.put2(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int):IntQueue = {  if (x >= 0) super.put(x); this }
  abstract override def put2(x: Int) {  if (x >= 0) super.put2(x)   }
}
//Warn:  Applied sequence                3          2                 1
val queue = (new BasicIntQueue with Doubling with Incrementing with Filtering )
queue.put2(10); queue.put2(-15); queue.put2(21)

queue.get(); queue.get();     //22 44

//Warn:  Applied sequence                3                2             1
val queue2 = (new BasicIntQueue with Incrementing with Filtering with Doubling  )
queue2.put2(10); queue2.put2(-15); queue2.put2(21)

//  For 10 :  20 -> ok -> 21
//  For 21 :  42 -> ok -> 43
queue2.get(); queue2.get();


/*
Overall, code written in this style gives you a great deal of flexibility. You can define (x) 16 different
classes by mixing in these three traits in different combinations and orders.
That’s a lot of flexibility for a small amount of code, so you should keep your eyes open for opportunities
to arrange code as stackable modifications.
*/






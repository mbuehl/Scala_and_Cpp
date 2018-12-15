

import java.util

import scala.collection.immutable.Queue

//x Chpt 19 Type parameterization allows you to write generic classes and traits.
//x For example, sets are generic and take a type parameter: they are defined as Set[T]
//x Unlike Java, which allows raw types, Scala requires that you specify type parameters. Variance defines inheritance
//x relationships of parameterized types, such as whether a Set[String], for example, is a subtype of Set[AnyRef].

//x     FUCTIONAL QUEUES  - once created ... stays like that forever

// A functional queue is a data structure with three operations:
// * head returns the first element of the queue
// * tail returns a queue without its first element
// * enqueue returns a new queue with a given element appended at the end

val q = Queue(1, 2, 3)
q enqueue(5)
q                //shows the first q [enqueued modified is another queue]

//X     DEFINITIONS

//One simple approach to implement a functional queue would be to use a list as representation type


class SlowAppendQueue[T](elems: List[T]) {        //x  Not efficient
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x)) //x THIS IS COSTLY - time prop to length !
}

class SlowHeadQueue[T](smele: List[T]) { //x   Not efficient - smele is elems reversed
def head = smele.last
  def tail = new SlowHeadQueue(smele.init)
  def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}

//The idea is to represent a queue by two lists,calledleadingandtrailing. Theleadinglistcontainselements towards the
// front, whereas the trailing list contains elements towards the back of the queue in reversed order. The
// contents of the whole queue are at each instant equal to  “leading ::: trailing.reverse”.

//x   BASIC IMPLEMENTATION FOR  QUEUE  Warn: there r 2 private Lists in constructor

class QueueA[T]( private val leading: List[T], private val trailing: List[T])
{
  private def mirror =
    if (leading.isEmpty)
      new QueueA(trailing.reverse, Nil)
    else this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new QueueA(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) =
    new QueueA(leading, x :: trailing)
}


val x = new QueueA(List(1,2),  List(3,4))
x.enqueue(77)

def prtQueue(x: QueueA[Int]) :Unit = {

  if(   )
  {
    println(x.head + ", ")
    prtQueue(x.tail)
  }
}

prtQueue(x)

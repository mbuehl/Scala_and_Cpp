//x   ch17  List buffers        mutable
//ListBuffer is a mutable object (contained in package scala.collection.mutable), which can help you build lists more efficiently   when you need to append
//x   You append elements with the += operator, and prepend them with the +=: operator

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]

buf += 1
buf += 2

4  +=: buf    //Warn        prepend

//Another reason to use ListBuffer instead of List is to prevent the potential for stack overflow

//x   Array buffers             mutable
//x   is like an array, except that you can additionally ADD and REMOVE elements from the beginning and end of the sequence

import scala.collection.mutable.ArrayBuffer

val bf = new ArrayBuffer[Int]()

bf += 12
bf += 15

bf.length

bf(1)

//x   Strings (via StringOps)  which implements many sequence methods. Because Predef has an implicit conversion
//x   from String to StringOps, you can treat any string like a sequence

def hasUpperCase(s: String) = s.exists(_.isUpper)

hasUpperCase("Robert Frost")

hasUpperCase("e e cummings")

//  Because no method named “exists” is declared in class String itself, the Scala compiler will implicitly convert s
//  to StringOps, which has the method


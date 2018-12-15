//9.3 Currying
//A curried function is applied to multiple argument lists, instead of just one

def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(1, 2)

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)

//What’s happening here is that when you invoke curriedSum, you actually
//  get two traditional function invocations back to back.

//The first function invocation takes a single Int parameter named x, and returns a function
//value for the second function. This second function takes the Int parameter y.

def first(x: Int) = (y: Int) => x + y

val second = first(1)

second(2)

//The underscore in curriedSum(1)_ is a placeholder for the second parameter
//list.2 The result is a reference to a function that, when invoked, adds one
//  to its sole Int argument and returns the result:
val onePlus = curriedSum(1)_
onePlus(2)

val twoPlus = curriedSum(2)_
twoPlus(2)

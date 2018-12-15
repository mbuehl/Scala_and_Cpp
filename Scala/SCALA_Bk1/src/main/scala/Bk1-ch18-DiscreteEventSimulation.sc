//x   18.3 Case study: Discrete event simulation

//How stateful objects can be combined with first-class function values in interesting ways.
//The example is taken from the classic textbook Structure and Interpreta- tion of Computer Programs by Abelson and Sussman [Abe96].

/*
You’ll see the design and implementation of a simulator for digital circuits.

This task is decomposed into several subproblems, each of which is interesting individually:
 F irst, you’ll see a little language for digital circuits.
 S econd, we’ll present a simple but general framework for discrete event simulation.
 F inally, we’ll show how discrete simulation pro- grams can be structured and built

The idea of such simulations is to model physical objects by simulated objects, and
to use the simulation framework to model physical time.
*/
type Action = () => Unit

class Wire
{
    private var sigVal = false
    private var actions: List[Action] = List()

    def getSignal = sigVal

    def setSignal(s: Boolean) =
      if (s != sigVal) {
        sigVal = s
        actions foreach (_ ())
      }

    def addAction(a: Action) = {
      actions = a :: actions
      a()
    }
}

val a, b, c = new Wire

def inverter(input: Wire, output: Wire)
def andGate(a1: Wire, a2: Wire, output: Wire)
def orGate(o1: Wire, o2: Wire, output: Wire)

/*

What’s unusual, given the functional emphasis of Scala, is that these procedures construct the gates as a side-effect,
instead of returning the constructed gates as a result. For instance, an invocation of inverter(a, b) places
an inverter between the wires a and b. It turns out that this side-effecting construction makes it easier
to construct complicated circuits gradually. Also, although methods most often have verb names, these have noun names
that indicate which gate they are making. This reflects the declarative nature of the DSL:
it should describe a circuit, not the actions of making one.

More complicated function boxes can be built from the basic gates. For instance, the method shown in Listing
18.6 constructs a half-adder. The halfAdder method takes two inputs, a and b, and produces a sum, s,
defined by “s = (a + b) % 2” and a carry, c, defined by “c = (a + b) / 2”

*/
//              IN       IN       OUT - sum % 2     OUT - carry
def halfAdder(a: Wire, b: Wire,    s: Wire,           c: Wire)
{
  val d, e = new Wire
  orGate(a, b, d)
  andGate(a, b, c)
  inverter(c, e)
  andGate(d, e, s)
}
/*
Note that halfAdder is a parameterized function box just like the three
methods that construct the primitive gates.
You can use the halfAdder method to construct more complicated circuits.

*/

def fullAdder(a: Wire, b: Wire, cin: Wire,
              sum: Wire, cout: Wire) {
  val s, c1, c2 = new Wire
  halfAdder(a, cin, s, c1)
  halfAdder(b, s, sum, c2)
  orGate(c1, c2, cout)
}
/*
For instance, the above - defines a full, one-bit adder, which takes two inputs,
a and b, as well as a carry-in, cin, and which produces a sum output defined
by “sum = (a + b + cin) % 2” and a carry-out output defined by  “cout = (a + b + cin) / 2”.
*/
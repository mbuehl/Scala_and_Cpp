//x   Ch  12
//
//x   Traits are like Java interfaces with concrete methods
//
//x   Can do anything in a trait definition that you can do in a class definition, and the syntax looks exactly the same,
//x   with only two exceptions:
//
//x   1st, a trait cannot have any “class” parameters, i.e., parameters passed to the primary constructor of a class.
//    trait NoPoint(n: Int, m: Int) // Does not compile
//
//x   2nd difference between classes and traits is that whereas in classes, super calls are statically bound, in traits,
//x   they are dynamically bound.
//    If you write “super.toString” in a class, you know exactly which method implementation will be invoked.
//    When you write the same thing in a trait, however, the method implementation to invoke for the super call is
//    undefined when you define the trait. Rather, the implementation to invoke will be determined anew each time
//    the trait is mixed into a concrete class. This curious behavior of super is key to allowing traits to work as
//x   "stackable modifications"
//
//    Overall, there is quite a lot of boilerplate code in this class which would be the same in any other class that implements comparison operations.
//x   This problem is so common that Scala provides a trait to help with it. The trait is called Ordered.
//    To use it, you replace all of the individual comparison methods with a single compare method.
//x   The *Ordered trait* then defines <, >, <=, and >= for you in terms of this one method.
//x   Thus, trait Ordered allows you to enrich a class with comparison methods by implementing only one method, compare.
//
//
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  override def toString = numer +"/"+ denom

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def realV:Double = this.numer/this.denom

  def isEqual(that: Rational):Boolean = {
    println(this.numer * that.denom - that.numer * this.denom)
    (this.numer * that.denom) - (that.numer * this.denom) == 0.0
  }

  def compare(that: Rational) = {
    println(this.numer * that.denom - that.numer * this.denom)
    (this.numer * that.denom) - (that.numer * this.denom)
  }
}


val half = new Rational(1,2)
val half0 = new Rational(10,20)
val third = new Rational(1,3)

val halfNTthird = half > third

val halfNhalfGT =  half > half0
val halfNhalfEQ = half == half0
val halfNhalfLT =  half < half0

val thirdNhalfLE = third <= half

val half0MINUShalf = (half0 - half).realV


val half_COMPAREhalf0 = half.compare(half0)
val half_isEqual_half0 = half.isEqual(half0)

//
/*
x   12.7 To trait, or not to trait?

Whenever you implement a reusable collection of behavior, you will have to decide whether you want to use a trait
or an (x) abstract class. There is no firm rule, but this section contains a few guidelines to consider.

If the behavior will not be reused, then (x) make it a concrete class. It is not reusable behavior after all.

If it might be reused in multiple, unrelated classes,(x) make it a trait. Only traits can be mixed into different parts
of the class hierarchy.

If you want to inherit from it in Java code, (x) use an abstract class. Since traits with code do not have a close Java
analog, it tends to be awkward to inherit from a trait in a Java class. Inheriting from a Scala class, meanwhile,
is exactly like inheriting from a Java class. As one exception, a Scala trait with only abstract members translates
directly to a Java interface, so you should feel free to define such traits even if you expect Java code to inherit
from it. See Chapter 31 for more information on working with Java and Scala together.

If you plan to distribute it in compiled form, and you expect outside groups to write classes inheriting from it,
you might (x) lean towards using an abstract class. The issue is that when a trait gains or loses a member,
any classes that inherit from it must be recompiled, even if they have not changed.
If outside clients will only call into the behavior, instead of inheriting from it, then using a trait is fine.

If efficiency is very important, lean towards using a (x) class. Most Java runtimes make a virtual method invocation
of a class member a faster oper- ation than an interface method invocation.
Traits get compiled to interfaces and therefore may pay a slight performance overhead.
However, you should make this choice only if you know that the trait in question constitutes a performance
bottleneck and have evidence that using a class instead actually solves the problem.

If you still do not know, after considering the above, then start by making it as a trait.
You can always change it later, and (x) in general using a trait keeps more options open.

 */
//
//




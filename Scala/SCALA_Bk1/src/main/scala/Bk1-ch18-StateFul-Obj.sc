//x ch 18  stateful object      For a stateful object, the result of a method call or field access may depend on
//x                             what operations were previously performed on the object.

class Keyed {
  def computeKey: Int = {       // ........... this will take some time
    println("Costly call ... obtaining value for 'computeKey' ...")
    150
  }
//....
}
//x                             Acting as a   c a c h e
class MemoKeyed extends Keyed
{
  private var keyCache: Option[Int] = None  //Warn: Important - this is how var is initd to NONE

  override def computeKey: Int =
  {
    if (!keyCache.isDefined) keyCache = Some(super.computeKey)

    keyCache.get                            //Warn:   Retrieving
  }

  def forget:Unit = {
    println("Un-seting value for 'computeKey' ...")
    keyCache = None
  }
}


val bla = new MemoKeyed()
bla.computeKey
bla.computeKey
bla.computeKey

bla.forget
bla.computeKey
bla.computeKey

//x   sometimes useful, to define a getter and a setter without an associated field
//An example is the following class Thermometer, which encapsulates a temperature variable that can be read and updated.

class Thermometer
{
  var celsius: Float = _    //The celsius variable is initially set to a default value by specifying ‘_’ as the “initializing value”  (which is  0)
                            //More precisely, an initializer “= _” of a field assigns a zero value to that field
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) {
    celsius = (f - 32) * 5 / 9
  }
  override def toString = fahrenheit +"F/"+ celsius +"C"
}

val t = new Thermometer
t.celsius = 5.1f
t
t.fahrenheit = 95.0f
t

/*
warn    Nota: that you cannot simply leave off the “= _” initializer in Scala.
warn    If you had written:

warn      var celsius: Float

warn    this would declare an ABSTRACT variable (chpt.20), not an UNINITIALIZED one
 */

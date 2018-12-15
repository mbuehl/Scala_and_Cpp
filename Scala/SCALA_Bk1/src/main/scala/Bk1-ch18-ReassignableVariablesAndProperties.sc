//x 18.2 Reassignable variables and properties

class Time0 {
  var hour = 12                 // getter and setter
  var minute = 0
}

//This implementation is exactly equivalent to the class definition shown BELOW

class Time1 {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h             //getter
  def hour_=(x: Int) { h = x }  //setter     Warn   underscore signifies setter

  def minute: Int = m           //getter
  def minute_=(x: Int) { m = x }//setter     Warn   underscore signifies setter
}

//Defining getter and setter methods directly
//Class Time2 contains requirements that catch all assignments to hour and minute with illegal values.
class Time2
{
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_= (x: Int) {
    require(0 <= x && x < 24)       //Warn: setter with explicit rectriction (will throw exception)
    h = x
  }

  def minute = m
  def minute_= (x: Int) {
    require(0 <= x && x < 60)       //Warn: setter with  explicit rectriction
    m = x
  }
}

//Scala’s  convention of always interpreting a variable as a pair of setter and getter
//methods gives you in effect the same capabilities as C# properties without requiring special synta




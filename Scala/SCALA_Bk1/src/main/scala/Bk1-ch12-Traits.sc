trait Philosophical {
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  def attrib = "philosophical"
  override def toString = "green"
}

new Frog philosophize()


trait Animal {
  def attrib = "is animal generally "

}
trait HasLegs {
  def attrib = "has Legs"
}

class Frog2 extends Animal with HasLegs with  Philosophical {
  override def toString = "green"

  def atrrib = "Frog2 " + super.attrib
}

new Frog2 atrrib


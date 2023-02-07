package lectures.part2_oop

object AbstractDataTypes extends App {

  // abstract members
  abstract class Animal{

    val creatureType: String
    def eat: Unit

  }

  class Dog extends Animal{

    val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch im a dog")

  }

  // traits
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"a
    def eat: Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc eat dog

  // traits vs abstract classes
  // 1. traits do not have constructor parameters
  // 2. Only 1 class extends, multiple traits
  // 3. traits are behaviours, abstract class are "things" "objects"
}


package lectures.part2_oop

object InheritanceAndTraits extends App{
  // Single class inheritance
  // Private functions can only be accessed within the class
  // Protected functions can only be accessed within the class and sub classes
  class Animal{
    val creatureType: String = "Wild"
    def eat = println("Yummy")

  }
  class Cat extends Animal {

    def crunch ={
      eat
      println("crunch crunch")
    }
  }
  val michigan = new Cat
  michigan.crunch

  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  // Works for methods, values and variables
  class Dog( override val creatureType: String) extends Animal {
    override def eat: Unit = {
      super.eat
      println("yamm yamm")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  // Prevent overrides
  // 1. use final on member
  // 2. use final on class
  // 3. seal the class = extend classes in this file, prevent extensions in other files

}


package lectures.part2_oop

object OOBasics extends App{

  val person = new Person(name = "Gonzo", age = 22)
  person.greet("Pepe")
  person.greet()
}

//Constructor
// class parameters are not FIELDS
class Person(name: String, age: Int) {

  // method
  def greet(name: String): Unit = println(s"${this.name} say's hi to $name")
  // overloading the method
  def greet(): Unit = println(s"$name say's hi to $name")

}


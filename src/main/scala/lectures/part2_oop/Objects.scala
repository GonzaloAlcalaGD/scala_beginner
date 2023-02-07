package lectures.part2_oop

object Objects extends App {

  // Scala does not have class-level functionality ("static")
  // COMPANIONS
  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
  }
  class Person(name: String) {
    // instance-level functionality
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects are singleton instances by default
  val mary = Person("Mary")
  val john = Person("John")
  println(mary == john)

}

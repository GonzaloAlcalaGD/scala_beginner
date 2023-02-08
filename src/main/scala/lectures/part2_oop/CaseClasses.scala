package lectures.part2_oop

object CaseClasses extends App{

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  val jim2 = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim)

  // 3. equals and hashcode implemented
  println( jim == jim2)

  // 4. case classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case classes are serializable

  // 7. case classes have extractor patterns = can be use in pattern matching

  case object UK{
    def name: String = "The United Kingdom of Great Britain and Northern Ireland"
  }

  /*
  * Expand MyList to use case classes and case objects
  */



}



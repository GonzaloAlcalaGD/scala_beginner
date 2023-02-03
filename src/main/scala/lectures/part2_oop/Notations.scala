package lectures.part2_oop

import scala.language.postfixOps

object Notations extends App{
   /*
    * 1. Overload + operator
          - mary + "the rockstar" => new person with "Mary (the rockstar) favMovie
      2. Add age to the Person class : 0
          - Add a unary + operator = > new person with the age + 1
      3. Add a "learns" method in Person class => Mary learns "   "
          - Add a learnsScala method() calls the learns method with "Scala" as param use it in postfix notation
      4. Overload apply method
          - mary.apply(2) => "Mary watched Inception 2 times"
    * */
  class Person(val name: String, val favoriteMovie: String, val age: Int = 0){

    def likes(movie: String): Boolean = (movie == favoriteMovie)

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_! : String = s"$name, what the heck"

    def unary_+ : Person = new Person(name, favoriteMovie, age+1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(topic: String): String = s"$name is learning $topic"

    def learnsScala = this.learns("Scala")

  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club", 23)

  // Both are equivalent
  // Infix notation = operator notation
  println(mary.likes("Inception"))
  println(mary.+(tom))
  // Syntactic sugar
  println(mary likes "Inception")
  println(mary + tom)

  //Prefix notation
  val x = -1 // .unary_-
  val y = 1.unary_- // -1
  //unary_ only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // only available with methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())  // Equivalent
  println(mary()) // Equivalent

  println((mary + "the rockstar")())
  println((+mary).age)

  println(mary learnsScala)
  println(mary(5))

  
}

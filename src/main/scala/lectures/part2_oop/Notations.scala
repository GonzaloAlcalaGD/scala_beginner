package lectures.part2_oop

import scala.language.postfixOps

object Notations extends App{

  class Person(val name: String, favoriteMovie: String){

    def likes(movie: String): Boolean = (movie == favoriteMovie)

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")

  // Both are equivalent
  // Infix notation = operator notation
  println(mary.likes("Inception"))
  println(mary.hangOutWith(tom))
  // Syntactic sugar
  println(mary likes "Inception")
  println(mary hangOutWith tom)

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
  
}

package lectures.part2_oop

import java.util.Calendar

//Constructor
// class parameters are not FIELDS
class Person(name: String, age: Int) {

  // method
  def greet(name: String): Unit = println(s"${this.name} say's hi to $name")

  // overloading the method
  def greet(): Unit = println(s"$name say's hi to $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
 Writer: first_name, surname, year
  - method returns full name

  Novel: name, year of release, author
  - method returns author age
  - method returns who wrote the novel
  - method copy new year of release => new instance of Novel
*/

class Writer(val firstName: String, val surName: String, val year: Int){

  def writerFullName(): String = s"${this.firstName} ${this.surName}"

}

class Novel(name: String, yearOfRelease: Int, author: Writer){

  def authorAge(): Int = {
    val cal = Calendar.getInstance()
    cal.get(Calendar.YEAR )-author.year
  }

  def isWrittenBy(): String = s"${author.writerFullName()} wrote the novel $name"

  def newRelease(newYOE: Int) = new Novel(name, newYOE, author)

}


/*
 Counter: int value
 - method return current count
 - method increment => new Counter
 - method decrement => new Counter
 - overload increment/decrement to receive an amount
*/

class Counter(val count: Int = 0){

  def currentCount(): Int = count

  def increment = {
    println("Incrementing")
    new Counter(count + 1)
  }

  def decrement = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  } // immutability for objects

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  } // immutability for objects

  def print = println(count)
}


object OOBasics extends App{

  val person = new Person(name = "Gonzo", age = 22)
//  person.greet("Pepe")
//  person.greet()

  // Create instances of author and novel
  val author = new Writer("Gonzalo", "Alcala", 2000)
  val novel = new Novel("Scala basics", 2022, author)
  val counter1 = new Counter
  // Create values from method output
  val fullname = author.writerFullName()
  val authorAge = novel.authorAge()
  val novelAuthor = novel.isWrittenBy()
  val newNovel = novel.newRelease(2023)
  // Print results
  println(s"Author full name is $fullname")
  println(s"Author age is: $authorAge")
  println(novelAuthor)
  println(newNovel)
  counter1.increment.print
  counter1.increment.increment.increment.print
  counter1.increment(10).print

}


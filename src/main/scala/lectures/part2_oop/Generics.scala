package lectures.part2_oop

import exercises.{Cons, Empty}

object Generics extends App{

    class MyList[+A] {
     // use type A
     // If B supertype of A return a list of B
     def add[B >: A](element: B): MyList[B] = ???
   }

    class myMap[Key, Value]{
      // use Key, Value
    }



  val listOfInts = new MyList[Int] // Replaces instances of A to Int
  val listOfStrings = new MyList[String] // Replaces instances of A to String

   // Generic methods
   object MyList {
     def empty[A]: MyList[A] = ???
   }

   val emptyListOfIntegers = MyList.empty[Int]

   // Variance problem
   class Animal
   class Cat extends Animal
   class Dog extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(Dog) == List pollution

  // INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // CONTRA-VARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // BOUNDED TYPES
  // Class cage only accepts class parameters A which are subtypes of Animal
  class Cage[A <: Animal](animal: A) {
    val cage = new Cage(new Dog)

  // class Car
  // val newCage = new Cage(new Car)

  }



}

abstract class MyList[A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add(element: A): MyList[A]
  def printElements: String
  override def toString: String = s"[$printElements]"

}

class Empty[A] extends MyList[A] {

  def head: A = throw new NoSuchElementException
  def tail: MyList[A] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: A): MyList[A] = new Cons(element, new Empty[A])
  def printElements: String = ""

}

class Cons[A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add(element: A): MyList[A] = new Cons(element, this)
  override def printElements: String = {
    if (t.isEmpty) s"${h.toString}"
    else s"$h, ${t.printElements}"
  }

}

object ListTest extends App{

  val listOfInts = new Cons(1, new Cons(2, new Cons(3, new Empty[Int])))
  println(listOfInts.tail.tail.head)
  println(listOfInts.add(4).head)
  println(listOfInts)

  val listOfStrings = new Cons("str1", new Cons("str2", new Cons("str3", new Empty[String])))
  println(listOfStrings.tail.tail.head)
  println(listOfStrings.add("str4").head)
  println(listOfStrings)

  val emptyListOfInts = new Empty[Int]
  val emptyListOfStrings = new Empty[String]
  println(emptyListOfInts.add(9))
  println(emptyListOfStrings.add("Pete"))
}
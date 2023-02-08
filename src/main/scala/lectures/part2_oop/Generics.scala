package lectures.part2_oop


object Generics {

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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatmap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}

object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Nothing): MyList[Nothing] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[Nothing] =  Empty

//  def flatmap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

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
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }
//  def flatmap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.testValue(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

}

trait MyPredicate[-T] {
  def testValue(value: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(input: A): B
}

object ListTest extends App{

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(input: Int): Int = input * 2
  }).toString)
}
package lectures.part2_oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  class Person(name: String){
    def sayHi: Unit = println(s"Hi my name is $name, how can I help?")
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal { def eat: Unit = println("hahahahaha") }
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi my name is Jim, how can i be of service?")
  }

  println(funnyAnimal.getClass)

  /*
    1. Generic trait MyPredicate[-T] (Every subclass has a different implementation)
      a. Method to test whether a value of T passes a condition | test(T) => Boolean
    2. Generic trait MyTransformer[-A, B]
      a. Method convert a value from A to B
    3. MyList:
      a. map(MyTransformer) => MyList
      b. filter(MyPredicate) => MyList
      c. flatMap(MyTransformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[T]
       Checks for even numbers returns a boolean if so.
    class StringToIntTransformer extends MyTransformer[String, Int]
       Transform Strings from the list into Integers

   [1,2,3].map(toString) => ["1", "2", "3"]
   [1,2,3,4].filter(n % 2) => [2, 4]
   [1,2,3].flatmap(n => [n, n+1]) => [1,2,2,3,3,4]

  */

  
}


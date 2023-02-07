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
}

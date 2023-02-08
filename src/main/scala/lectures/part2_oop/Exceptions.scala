package lectures.part2_oop

object Exceptions extends App{

  val x: String = null
  //  println(x.length)
  //  val aWeirdValue: String = throw new NullPointerException

  // Exceptions something went wrong in the program
  // Error something went wrong with the system

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try{
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a runtime exception")
  } finally {
    // code will get execute no matter what
    println("Finally")
  }

  // Define own exceptions
  class MyException extends Exception
  val exception = new MyException

  /*
   1. Crash program with an OutOfMemoryError
   2. Crash program with StackOverflowError
   3. PocketCalculator
      a. add(x,y)
      b. multiply(x,y)
      c. divide(x,y)
      d. subtract(x,y)

      Throw
      - Overflow exception if add(x,y) exceeds int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceeds int.MIN_VALUE
      - MathCalculationException  division by 0
  */
   // OutOfMemory
  //  val array = Array.ofDim(Int.MaxValue)

   // StackOverflow
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")


  object Calculator {
    def add(x:Int, y:Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x:Int, y:Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }

  println(Calculator.add(Int.MaxValue, 1))


}



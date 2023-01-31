package lectures.part1_basics

object Functions extends  App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 69))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())


  // WHEN YOU NEED  LOOPS , USE RECURSION
  def aRepeatedFunciton(aString: String, n: Int): String = {
    if (n == 1) aString else aString + aRepeatedFunciton(aString, n-1)
  }

  println(aRepeatedFunciton("Hello World ", 3))

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  /*
   1. Greeting function (name, age) => Hi my name is $name and I am $age years old
   2. Factorial function
   3. Fibonacci function
   4. Test if a number is prime
  */

  def aGreetingFunction(name: String, age: Int): Unit ={
    println("Hi my name is "+ name +" and I am "+ age +" years old")
  }

  def aFactorialFunction(number: Int): Int ={
    if (number == 1 || number == 0) then 1
    else number*aFactorialFunction(number-1)
  }

  def aFibonacciFunction(number: Int): Int ={
    if (number == 0) then 0
    if (number == 1 || number == 2) then 1
    else aFibonacciFunction(number-1)+aFibonacciFunction(number-2)
  }

  def aPrimeNumberfunction(number: Int, i: Int = 2): String ={
      if number == i then "Yes, it's a prime number"
      else if (number % i == 0) then "No, it's not a prime number"
      else aPrimeNumberfunction(number, i + 1)
  }


  aGreetingFunction("Gonzalo", 22)
  println(aFactorialFunction(number = 5))
  println(aFibonacciFunction(number = 6))
  println(aPrimeNumberfunction(number = 971))
}

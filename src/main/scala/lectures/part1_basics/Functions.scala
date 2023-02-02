package lectures.part1_basics

import scala.annotation.tailrec

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

  def aFactorialFunction(number: Int): BigInt ={
    if (number == 1 || number == 0) then 1
    else number*aFactorialFunction(number-1)
  }


  def aFactorialTailRecursion(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1 ) accumulator
      else factHelper(x - 1, x * accumulator)
    factHelper(n, 1)
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

  // WHEN LOOPS ARE NEEDED USE TAIL RECURSION
  aGreetingFunction("Gonzalo", 22)
  println(aRepeatedFunciton("Hello World ", 3))
  println(aFactorialTailRecursion(n = 50))
  println(aFibonacciFunction(number = 6))
  println(aPrimeNumberfunction(number = 971))



  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function tail recursive
  */


  @tailrec
  def aRepeatedTailRecursive(aString: String, n: Int, accumulator: String): String = {
      if (n <= 0) accumulator
      else aRepeatedTailRecursive(aString, n = n-1, aString+accumulator)
  }



  def aPrimeTailRecursive(n: Int): Boolean ={
    @tailrec
    def isPrimeTailRec(t: Int, Prime: Boolean): Boolean =
      if !(Prime) then false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n%t != 0 && Prime)

    isPrimeTailRec(n / 2, true)
  }


  def aFibonacciTailRecursive(number: Int): Int ={
    @tailrec
    def fibonacciHelper(n: Int, last: Int, nextToLast: Int): Int =
      if ( n >= number) last
      else fibonacciHelper(n+1, last + nextToLast, last)

    if (number <= 2) 1
    else fibonacciHelper(3, 1, 1)
  }


  println(aRepeatedTailRecursive("Hello everyone ", 3, ""))
  println(aPrimeTailRecursive(n = 2003))
  println(aPrimeTailRecursive(n = 602))
  println(aFibonacciTailRecursive(8))
}

package lectures.part1_basics

object DefaultArgs extends App{

  /*
  * Function that returns the factorial of a given number. Using tail recursion to prevent early
  * stack overflow
  * */
  def trFactorial(number: Int, acc: Int = 1): Int = {
    if (number <= 1) then acc
    else trFactorial(number - 1, number * acc)
  }

  val fact10 = trFactorial(number = 10)
}

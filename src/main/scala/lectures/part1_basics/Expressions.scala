package lectures.part1_basics

object Expressions extends App {

  // Operators
  // + - * / & | << >> >>>

  val x: Int = 1 + 2 //EXPRESSION
  println(x)

  println(2 + 3 * 4) //ALSO AN EXPRESSION

  // Logical operators
  // == != > >= < <=
  // ! && ||

  println(1 == x)
  println(!( 1 == x))

  var aVariable = 2
  aVariable += 3 // also works with  -= *= /= .... Only works with variables since they are side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition: Boolean = false
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  // Loops
  var i: Int = 0
  while (i < 10){
    println(i)
    i += 1
  }

  //NEVER WRITE THIS AGAIN.
  // EVERYTHING IN SCALA IT'S AN EXPRESSION
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  //side effects : println(), whiles, re-assigning

  //Code Blocks
  //Expression
  val aCodeblock = {
    val y: Int = 2
    val z: Int = y + 1

    if ( z > 2) "hello" else "goodbye" //The value of the code block its the type of the expression
  }

}


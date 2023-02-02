package lectures.part1_basics

object StringOps extends App{

  val str: String = "Hello, I'm learning Scala"

  println("Char at: ":+str.charAt(2))
  println("Substring: "+str.substring(7, 11))
  println("Split: "+str.split(" ").toList)
  println("Starts with: "+str.startsWith("Hello"))
  println("Replace: "+str.replace(" ", "-"))
  println("To lower case: "+str.toLowerCase())
  println("Length: "+str.length)

  // - S interpolators evaluate expressions inside the string
  val age: Int = 12
  val name: String = "Gonzalo"

  val firstGreeting = s"Hello my name is $name and I am $age year's old"
  val secondGreeting = s"Hello my name is $name and I will be turning ${age + 1} year's old"

  println(firstGreeting)
  println(secondGreeting)

  /* - F interpolators allow you to create printf-like formatted strings - use it if you really need a certain string
   * format, such as printing column-aligned values to stdout, for example
  */

  val speed: Float = 1.227f
  val myth: String = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // - raw interpolators are the same as S, only they do not escape literals such as \n - use it if you need to
  // eliminate character escaping

  println(raw"This is a \n new line")
  val scaped: String = "This is a \n new line"
  println(scaped)

}

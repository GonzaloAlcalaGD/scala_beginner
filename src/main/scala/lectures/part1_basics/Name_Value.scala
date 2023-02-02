package lectures.part1_basics

object Name_Value extends  App {

  def calledByValue(x: Long): Unit ={
    println("By value: "+x)
    println("By value: "+x)
  }

  def calledByName(x: => Long): Unit ={
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def inifinite(): Int = 1 + inifinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) Passes the value and gets evaluated which leads to stack overflow
  printFirst(34, inifinite()) // Passing the value by name delays the evaluation of infinite() allowing to not overflowing

}

package lectures.part2afp

/**
  * Created by YS1607131010 on 8/7/2018.
  */
object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1 // Function[Int, Int] === Int => Int

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 3 => 999
  } // partial function value

  println(aPartialFunction(2))
  //println(aPartialFunction(32452))

  // PF utilities
  println(aPartialFunction.isDefinedAt(67))

  // lift
  val lifted = aPartialFunction.lift // Int => Option[Int]
  println(lifted(2))
  println(lifted(98))

  val pfChain = aPartialFunction.orElse[Int, Int] {
    case 45 => 67
  }

  println(pfChain(2))
  println(pfChain(45))

  // PF extend normal functions

  val aTotalFunction: Int => Int = {
    case 1 => 99
  }

  // HOFs accept partial functions as well
  val aMappedList = List(1,2,3).map {
    case 1 => 42
    case 2 => 78
    case 3 => 1000
  }
  println(aMappedList)

  /*
   Note: PF can only have one parameter type
   */

  /*
     Exercises

     1. Construct a PF instance yourself (anonymous class)
     2. Dumb chatbot as a PF
   */

  // Exercise 1: a PF instance

  // Exercise 2: dumb chatbot
  val dumbChatbotPF: PartialFunction[String, Unit] = {
    case line:String => println("you said: " + line)
    case _ => println("you said nothing")
  }

  scala.io.Source.stdin.getLines().foreach(line => dumbChatbotPF(line))
}

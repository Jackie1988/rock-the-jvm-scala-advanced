package lectures.part1as

/**
  * Created by YS1607131010 on 8/1/2018.
  */
object Recap extends App {

  //functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1
  List(1,2,3).map(anonymousIncrementer) //HOF
  // map, flatMap, filter

  //for-comprehension
  val pairs = for {
    num <- List(1,2,3) // if condition
    char <- List("a", "b", "c")
  } yield num + "-" + char

  //Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 555
  )

  // "collections": Options, Try
  val anOption = Some(2)

  //pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  case class Person(name: String, age: Int)

  val bob = Person("bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi, my name is $n"
  }
}

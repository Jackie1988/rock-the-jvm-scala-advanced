
val listA: List[String] = List("abc", "def", "ghk")

val listB: List[String] = listA ++ List("xyz")

val listC: List[String] = listB ::: List("asd")

val listD: List[String] = listC ::: List("qwe")

val index0 = listD(0)
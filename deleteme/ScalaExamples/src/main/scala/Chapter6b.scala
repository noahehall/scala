object Chapter6b {
  val intList: List[Int] = List(1, 2, 3, 4, 5)
  val emptyList: List[Int] = List()
  val emptyList2: List[Int] = Nil
  val head: Int = intList.head // can throw an exception
  val headOption = intList.headOption
  val tail: List[Int] = intList.tail
  val consList = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
  val intList2 = List(1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 4, 4)
  val distinct = intList2.distinct
  val length = intList2.length
  val drop = intList.drop(1)
  val take = intList.take(1)

  val map = intList.map(i => i * 2)
  val mapSyntacticSugar = intList.map(_ * 2)

  def elementAndAddOne(ns: List[Int]): List[Int] = ns.flatMap(n => List(n, n + 1))

  val names = List("Moana", "Jasmine")
  val namesUpperCase = names.map(_.toUpperCase)
  val namesUpperCase2 = names.map(_.toUpperCase).flatten
  val namesUpperCase3 = names.flatMap(_.toUpperCase)

  for {
    i <- intList
    if i > 5
  } yield List(i, i + 1)

  for {
    name <- names
    if name.contains("j")
  } yield name.toUpperCase

  def combination(xs: List[Int], ys: List[Int]): List[(Int, Int)] =
    for {
      x <- xs
      y <- ys
    } yield (x, y)
}

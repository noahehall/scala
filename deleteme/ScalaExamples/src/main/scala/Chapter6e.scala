object Chapter6e {
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

  val names = List("Amina", "Majeed")
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

  // challenge
  case class Destination(city: String, journeyTime: Int)

  val destinations = List(
    Destination("London", 30),
    Destination("Oxford", 120),
    Destination("Brighton", 100),
    Destination("Birmingham", 180),
    Destination("Edinburgh", 420)
  )

  def nearbyTrips(destinations: List[Destination]): List[String] =
    for {
      destination <- destinations
      if destination.journeyTime < 120
    } yield destination.city
  end nearbyTrips

  val head2 = destinations.head
  val tail2 = destinations.tail
  val sortedByCityName = destinations.sortBy(_.city)
  val sortedByJourneyTime = destinations.sortBy(_.journeyTime)
}

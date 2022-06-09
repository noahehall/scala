object Chapter5e {
  val middleName: Option[String] = None
  val middleName2: Option[String] = Some("Muna")
  val middleNameLength = middleName2.getOrElse("").length

  middleName2.map(word => word.toUpperCase)

  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])

  case class Film(name: String, rating: Option[Rating])

  val mulan: Film = Film("Mulan", Some(Rating(Some(2), Some(4))))

  mulan.rating.map(rating => rating.googleRating).flatten

  mulan.rating.flatMap(rating => rating.googleRating)

  val averageRating1: Option[Int] = for {
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    if googleRating > 3
    averageRating = (googleRating + netflixRating) / 2
  } yield netflixRating

  val averageRating2: Option[Int] = for
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    averageRating = (googleRating + netflixRating) / 2
  yield averageRating
  end averageRating2

  // challenge
  val number: Option[Int] = Some(5)
  val numberDoubled = number.map(n => n * 2)
  val numberDoubled2 = number.map(_ * 2)

  case class TicketPrice(standardTicketPrice: Int, firstClassTicketPrice: Option[Int])

  def getFirstClassTicketPrice(ticket: Option[TicketPrice]): Option[Int] =
    ticket.flatMap(_.firstClassTicketPrice)

  def getFirstClassTicketPrice2(ticket: Option[TicketPrice]): Option[Int] =
    for
      t <- ticket
      firstClassPrice <- t.firstClassTicketPrice
    yield firstClassPrice
  end getFirstClassTicketPrice2

  val londonToParis = TicketPrice(100, Some(200))
}

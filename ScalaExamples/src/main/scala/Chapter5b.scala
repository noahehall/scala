object Chapter5b {
  val middleName: Option[String] = None
  val middleName2: Option[String] = Some("Muna")
  val middleNameLength = middleName2.getOrElse("").length

  middleName2.map(word => word.toUpperCase)

  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])

  case class Film(name: String, rating: Option[Rating])

  val mulan: Film = Film("Mulan", Some(Rating(Some(2), Some(4))))

  mulan.rating.map(rating => rating.googleRating).flatten

  mulan.rating.flatMap(rating => rating.googleRating)

  val averageRating1 = for {
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    if googleRating > 3
    averageRating = (googleRating + netflixRating) / 2
  } yield netflixRating

  val averageRating2 = for
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    averageRating = (googleRating + netflixRating) / 2
  yield averageRating
  end averageRating2
}

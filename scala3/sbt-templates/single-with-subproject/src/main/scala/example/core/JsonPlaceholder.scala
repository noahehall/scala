package example.core

import gigahorse._, support.okhttp.Gigahorse
import scala.concurrent._, duration._
import play.api.libs.json._

object JsonPlaceholder {
  lazy val http = Gigahorse.http(Gigahorse.config)

  def fetch: Future[String] =
    val jsonEndpoint = "https://jsonplaceholder.typicode.com/todos/1"
    val getConfig = Gigahorse.url(jsonEndpoint).get
    import ExecutionContext.Implicits.global
    for {
      loc <- http.run(getConfig, parse)
    } yield Json.stringify(loc)

  private def parse = Gigahorse.asString andThen Json.parse
}
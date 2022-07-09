package example

import scala.concurrent._, duration._
import core.JsonPlaceholder

object Hello {
  def main(args: Array[String]): Unit = {
    val w = Await.result(JsonPlaceholder.fetch, 10.seconds)
    println(s"Fetched from JsonPlaceholder: $w")
    JsonPlaceholder.http.close()
  }
}
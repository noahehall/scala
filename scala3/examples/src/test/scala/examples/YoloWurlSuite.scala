package examples

import com.sun.net.httpserver.HttpServer
import munit.{FunFixtures, FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}

import scala.math.abs

class YoloWurlSuite extends FunSuite, FunFixtures, ScalaCheckSuite:
  // unit tests via FunSuite
  // provides the assert
  test("ima unit test") {
    assert(1 == 1)

    val one = 1;
    val won = 1;
    assertEquals(one, won)
  }

  val optionalPropertyDomain: Gen[Int] = Gen.choose(-1000, Int.MaxValue)
  // further limit the scope
  // optionalPropertyDomain.suchThat(n => n > 0) // only get positive values

  // property tests via ScalaCheckSuite
  property("ima property test") {
    // supplies arbitrary Int values
    // should return boolean true for passing tests
    Prop.forAll(optionalPropertyDomain) { (n: Int) =>
      (abs(n) * 2) % 2 == 0
    }
  }

/* TODO
  // create a fixture httpServer for a single test
  // note this runs setup & teardown before and after each test that uses it
  val withHttpServer = FunFixture[HttpServer](
    // setup fn
    setup = test => {
      val httpServer = HttpServer()
      httpServer.start(8888)
      httpServer
    },
    // teardown fn
    teardown = httpServer => httpServer.stop()
  )

  // a test that uses an httpServer
  withHttpServer.test("ima a integration test") { httpServer =>
    // perform http request here
  }
*/
  /**
   * alternative setup and teardown thats invoked beforeAll and afterAll
   * instead of beforeEach and afterEach
   val httpServer = HttpServeR()
   override def beforeAll(): Unit = httpServer.start(8888)
   override def afterAll(): Unit = httpServer.stop()
   */
end YoloWurlSuite

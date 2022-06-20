import scala.collection.mutable

trait AB[T]:
  def unapply(s: T): Option[T] = Option(s)

case class A(s: String) extends AB[String]
case class B(s: String) extends AB[String]

object AB:
  def test[T](args: List[AB[T]]) = args match
  case A(a) :: B(b) :: _ => (A(a), B(b))
  case _ => (args(0), args(1))

val (first, second) = AB.test(List(A("ima a"), B("ima b")))
//val first: AB[String] = A(ima a)
//val second: AB[String] = B(ima b)
import scala.collection.mutable
// Actor, ActorRef come from akka
type Receive = PartialFunction[Any, Unit]

trait Actor:
    def receive: Receive

def zip[B](list: List[B]): List[(A,B)] = {
  def go(xs: List[A], ys: List[B]): List[(A,B)] = (xs, ys) match {
    case (Nil,Nil)  => List.Nil
    case (List.Cons(xh, xt), List.Cons(yh, yt)) =>
      List.Cons((xh, yh), go(xt, yt))
  }
  

  def map[B](f: (A) => B): List[B] = {
    def go(xs: List[A], acc: List[B]): List[B] = {
      xs match {
        case List.Nil => acc
        case List.Cons(xh, xt) => List.Cons(f(xh), go(xt, acc))
      }
    }
    go(this,List.Nil)
  }

  def transpose[A] (l: List[List[A]]): List[List[A]] = {
    def go(ls: List[List[A]], acc: List[List[A]]): List[List[A]] = ls match {
      case Nil => acc
      case Cons(head,tail) => go(tail, head.zip(acc))
    }
  }
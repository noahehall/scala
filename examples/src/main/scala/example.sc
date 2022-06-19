import scala.collection.mutable

def postCondition(throwIt: Boolean): String = {
    if throwIt == false then "wont throw" else ""
} ensuring (_.length != 0, "fails if ensuring returns false")


val poop = List(List(1, 2), List(true, false))
println(poop)

def stringify[A](thing: A): String = thing.toString
stringify[Int](1)
stringify[Boolean](true)

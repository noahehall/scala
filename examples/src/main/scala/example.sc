import scala.collection.mutable

def postCondition(throwIt: Boolean): String = {
    if throwIt == false then "wont throw" else ""
} ensuring (_.length != 0, "fails if ensuring returns false")


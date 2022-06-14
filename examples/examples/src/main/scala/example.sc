import scala.collection.mutable

val list = List(1,2,3)

for (x <- 1 to 10) do println(x * x)

val data = mutable.HashMap.empty[String, Int]

data += ("a" -> 0)
data += ("b" -> 1)
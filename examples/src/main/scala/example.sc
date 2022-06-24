import scala.collection.mutable


val x: List[Int] = List(1,2,3)

for (y <- x.withFilter(z => z > 2)) yield println(y)
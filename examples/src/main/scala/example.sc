import scala.collection.mutable


extension (n: Int)
    def isZero: Boolean = n == 0
val five = 5
given intReverseOrdering: Ordering[Int] = Ordering.Int.reverse
println(List(1,2,3).min)
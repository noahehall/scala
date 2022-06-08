@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  val poop = "flush"
  println(poop)
  println(sum(1, 1))
  println(isTruthy(me = true)) // with named param
  println(isTruthy()) // uses the default value defined in the fn signature

def msg = "I was compiled by Scala 3. :)"

def sum(n1: Int, n2: Int): Int = n1 + n2

// has default value of false
def isTruthy(me: Boolean = false): String = if me then "you are truthy" else "you are falsy"
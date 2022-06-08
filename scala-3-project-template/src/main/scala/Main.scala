@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  val poop = "flush"
  println(poop)
  println(sum(1, 1))
  println(isTruthy(false))
  println(isTruthy(true))

def msg = "I was compiled by Scala 3. :)"

def sum(n1: Int, n2: Int): Int = n1 + n2

def isTruthy(me: Boolean): String = if me then "you are truthy" else "you are falsy"
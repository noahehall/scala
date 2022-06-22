import scala.collection.mutable

enum JSON:
  case Seq (elems: List[JSON])
  case Obj (bindings: Map[String, JSON])
  case Num (num: Double)
  case Str (str: String)
  case Bool (b: Boolean)
  case Null

val jsData = JSON.Obj(Map(
  "name" -> JSON.Str("noah"),
  "mobile" -> JSON.Obj(Map(
    "area" -> JSON.Num(415),
    "number" -> JSON.Num(4154155)
  )),
  "skills" -> JSON.Seq(List(
    JSON.Str("app dev"),
    JSON.Str("growth hacking")
  ))
))
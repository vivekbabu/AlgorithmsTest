package in.algorithms.json

abstract class JSON  
case class JSeq(elems: List[JSON]) extends JSON
case class JObj(elems : Map[String,JSON]) extends JSON
case class JStr(str : String) extends JSON
case class JNum(num : Double) extends JSON
case class JBool(b : Boolean) extends JSON
case class JNull




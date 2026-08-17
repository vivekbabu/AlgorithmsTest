package in.algorithms.json

object JSONOperations {

  def main(args: Array[String]) {
  
}
  
  def show(json: JSON): String = {
    json match {
      case JSeq(elems) =>
        "[" + (elems map show mkString ", ") + "]"
      case JObj(elems) =>
        "{" + (elems.map { case (k, v) => "\"" + k + "\": " + show(v) }.mkString(", ")) + "}"
      case JStr(str) =>
        "\"" + str + "\""
      case JNum(num) =>
        num.toString
      case JBool(b) =>
        b.toString
      case JNull =>
        "null"
    }
  }

}
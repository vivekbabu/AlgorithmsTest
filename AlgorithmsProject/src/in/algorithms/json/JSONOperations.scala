package in.algorithms.json

object JSONOperations {

  def main(args: Array[String]) {
  
}
  
 def show(json : JSON) : String = {
    json match {
      
      case JSeq(elems) => 
        "[" + (elems map show mkString ",") + "]"
    }
  }

}
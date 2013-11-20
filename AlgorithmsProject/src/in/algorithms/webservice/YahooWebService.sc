package in.algorithms.webservice

import scala.io._
import scala.xml._
import scala.actors._
import Actor._
object YahooWebService {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def getWeatherData(cityId : Int) = {
  	var url = "http://weather.yahooapis.com/forecastrss?w=" + cityId
  	var xmlResponse = XML.loadString(scala.io.Source.fromURL(url).mkString)
  	println(xmlResponse \\ "location" \\ "@city",xmlResponse \\ "location" \\ "@region",xmlResponse \\ "condition" \\ "@temp" )
  
  }                                               //> getWeatherData: (cityId: Int)Unit
  
  // Get weather in New York
  val start = System.nanoTime()                   //> start  : Long = 84188015263502
  val caller = self                               //> caller  : scala.actors.Actor = scala.actors.ActorProxy@4eeba477
  for(i <- 2391271 to 2391279) {actor{caller !  getWeatherData(i)}}
	  for(i <- 2391271 to 2391279) {receiveWithin(5000) {case msg => msg	}}
                                                  //> (Denver,OR,46)
                                                  //| (Denver,WV,39)
                                                  //| (Denver,OH,46)
                                                  //| (Denver,OH,44)
                                                  //| (Denver,SC,59)
                                                  //| (Denver,PA,40)
                                                  //| (Denver,OK,32)
                                                  //| (Denver,TN,53)
                                                  //| (Denver,CO,33)
	
  val end = System.nanoTime()                     //> end  : Long = 84189769070322
  println("Total time= " +  (end-start)/1000000000.0)
                                                  //> Total time= 1.75380682
  
}
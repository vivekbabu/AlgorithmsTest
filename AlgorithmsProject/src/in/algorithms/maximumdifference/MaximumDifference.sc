package in.algorithms.maximumdifference

object MaximumDifference {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val array = List(1, 2, 90, 10, 110)             //> array  : List[Int] = List(1, 2, 90, 10, 110)
  
  def maximumDifference(givenArray : List[Int]) : Int = {
  	var minimumElement = givenArray(0)
  	var maximumDifference = givenArray(1)  - givenArray(0)
  	
  	for(i <- 1 to givenArray.size -1) {
  		if(givenArray(i) - minimumElement > maximumDifference)
  		{
					  maximumDifference =  givenArray(i) - minimumElement
  		}
  		
  		if(givenArray(i) < minimumElement)
  			minimumElement = givenArray(i)
  	
  	}
  	
  	maximumDifference
  }                                               //> maximumDifference: (givenArray: List[Int])Int
  
  maximumDifference(array)                        //> res0: Int = 109
  
  
  
}
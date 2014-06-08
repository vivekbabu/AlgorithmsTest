package in.algorithms.activityselection

object ActivitySelection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val activities = Array.ofDim[(Int, Int)](7)     //> activities  : Array[(Int, Int)] = Array(null, null, null, null, null, null, 
                                                  //| null)
  activities(0) = (3,4)
  activities(1) = (0,6)
  activities(2) = (1,2)
  activities(3) = (5,7)
  activities(4) = (8,9)
  activities(5) = (1,8)
  activities(6) = (9,10)
  
  
  def findMaxSetOfActivities(activities : Array[(Int,Int)]) ={
  
  	val sortedActivities = 	activities.sortWith((a :(Int, Int),b : (Int, Int)) => (a,b) match {
  			case ((fst,sec), (thi,fort)) =>  sec < fort
  		} )
  	var setCount = 0
  	val selectedActivities = Array.ofDim[(Int,Int)](sortedActivities.length)
  	selectedActivities(setCount) = sortedActivities(0)
  	setCount = setCount + 1
  	var i  = 0
 		for( j <- 1 to sortedActivities.length - 1) {
 			val (curFir,curSec) = sortedActivities(j)
 			val (prevFir,prevSec) = sortedActivities(i)
 			if(curFir >= prevSec) {
 			selectedActivities(setCount) = (curFir, curSec)
 			setCount = setCount + 1
 			i=j
 			}
 		}
 	println("Total set count is = " + setCount)
 	for(i <- 0 to setCount -1) {
 		println(selectedActivities(i))
 	}
	
  }                                               //> findMaxSetOfActivities: (activities: Array[(Int, Int)])Unit
  
  findMaxSetOfActivities(activities)              //> Total set count is = 5
                                                  //| (1,2)
                                                  //| (3,4)
                                                  //| (5,7)
                                                  //| (8,9)
                                                  //| (9,10)
  
}
package in.algorithms.rotatedarray

object RotatedArray {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val array = Array(6,7,8,9,10,11,1,2,3,4,5)      //> array  : Array[Int] = Array(6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5)
	def binarySearch(start : Int, end : Int) : Int= {
		if(start == end)
			start
		else {
			val mid = (start + end) /2
			if(array(mid) < array(mid-1)) mid
			else if (array(mid) > array(end)) binarySearch(mid + 1, end)
			else binarySearch(start, mid -1)
		
		}
	}                                         //> binarySearch: (start: Int, end: Int)Int
	
	val smallestElementIndex = binarySearch(0, array.length -1)
                                                  //> smallestElementIndex  : Int = 6
	println("The smallest element is " + array(smallestElementIndex))
                                                  //> The smallest element is 1
	println("The array is rotated " + smallestElementIndex + " times")
                                                  //> The array is rotated 6 times
	
}
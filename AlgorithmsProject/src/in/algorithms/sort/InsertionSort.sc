package in.algorithms.sort

object InsertionSort {
	def insertionSort(xs : List[Integer]) : List[Integer] = {
		xs match {
			case List() => List()
			case y :: ys => insert(y, insertionSort(ys))
		}
	}                                         //> insertionSort: (xs: List[Integer])List[Integer]
	def insert(x : Integer , xs : List[Integer]) : List[Integer] = {
		xs match {
			case List() => List(x)
			case y :: ys => if(x < y) x :: xs else y :: insert(x, ys)
		}
	}                                         //> insert: (x: Integer, xs: List[Integer])List[Integer]
	
	insertionSort(List(2, 1, 3, 6, 5, 4))     //> res0: List[Integer] = List(1, 2, 3, 4, 5, 6)
}
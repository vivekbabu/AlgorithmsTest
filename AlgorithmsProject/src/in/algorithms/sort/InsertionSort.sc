package in.algorithms.sort

object InsertionSort {
	def insertionSort(xs : List[Integer]) : List[Integer] = {
		xs match {
			case List() => List()
			case y :: ys => insert(y, insertionSort(ys))
		}
	}
	def insert(x : Integer , xs : List[Integer]) : List[Integer] = {
		xs match {
			case List() => List(x)
			case y :: ys => if(x < y) x :: xs else y :: insert(x, ys)
		}
	}
	
	insertionSort(List(2, 1, 3, 6, 5, 4))
}
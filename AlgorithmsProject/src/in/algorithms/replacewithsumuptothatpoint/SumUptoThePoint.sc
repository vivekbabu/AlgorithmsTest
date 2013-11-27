package in.algorithms.replacewithsumuptothatpoint
import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec
object SumUptoThePoint {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val buf = scala.collection.mutable.ListBuffer.empty[Int]
                                                  //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  buf.appendAll(List(2, 7, 1, 4, 5, 8, 6))

  def findTheSum(): Unit = {
    @tailrec
    def replaceWithSum(list: ListBuffer[Int], currentIndex: Int, currentSum: Int): Unit = {
      if (!list.isEmpty) {
        buf(currentIndex) = currentSum + list.head
        replaceWithSum(list.tail, currentIndex + 1, currentSum + list.head)
      }
    }
    replaceWithSum(buf, 0, 0)
  }                                               //> findTheSum: ()Unit
  findTheSum
  buf                                             //> res0: scala.collection.mutable.ListBuffer[Int] = ListBuffer(2, 9, 10, 14, 19
                                                  //| , 27, 33)
}
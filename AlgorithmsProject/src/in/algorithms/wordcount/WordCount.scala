package in.algorithms.wordcount

object WordCount {
	def main(args: Array[String]) {
		println(scala.io.Source.fromURL("http://docs.scala-lang.org/overviews/parallel-collections/custom-parallel-collections.html")
		.getLines.flatMap(_.split(" "))
		.foldLeft(Map[String,Int]())((count, word) => count + (word ->(count.getOrElse(word, 0)+1))))
}
}
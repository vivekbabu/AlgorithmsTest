package in.designpatterns.singleton

object SingletonSimulator {
  def main(args: Array[String]) {
    for (i <- 1 to 10)
      Singleton.incrementcalls
    Singleton.printCalls

  }

}


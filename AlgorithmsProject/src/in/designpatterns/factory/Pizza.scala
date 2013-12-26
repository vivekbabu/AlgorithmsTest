package in.designpatterns.factory

trait Pizza {
  var name = "Base Pizza"
  var description = "Base Pizza description"
  def prepare() = println("Default prepare : Preparing " + name)
  def bake() = println("Default bake : Preparing " + name)
  def cut() = println("Default cut : Preparing " + name)
  def box() = println("Default box : Preparing " + name)
}
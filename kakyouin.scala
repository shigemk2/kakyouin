import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var j = 0
    source.foreach( { i =>
      println(i)
      println(j)
      j += 1
    })
    source.close
  }
}

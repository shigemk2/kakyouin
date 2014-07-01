import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    source.foreach( { i =>
      println(i)
    })
    source.close
  }
}

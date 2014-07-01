import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var rero = ""
    source.foreach( { i =>
      rero += i
    })
    var array = rero.split("[\\s]+")
    array.foreach(println)
    source.close
  }
}

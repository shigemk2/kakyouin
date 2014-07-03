import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var rero = ""
    var mem = new Array[Int](30000)
    var curmem = 0
    var i = 0
    var nest = 0

    source.foreach( { i =>
      rero += i
    })
    var array = rero.split("[\\s]+")
    array.foreach(println)
    source.close
  }
}

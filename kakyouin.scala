import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var list = List.empty[Char]
    var rero = ""
    source.foreach( { i =>
      rero += i
    })
    println(rero)
    println(rero.split(" "))
    source.close
  }
}

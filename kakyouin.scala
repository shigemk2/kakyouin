import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var list = List.empty[Char]
    var j = 0
    source.foreach( { i =>
      list = i :: list
      // println(i)
      // println(j)
      j += 1
    })
    println(j)
    println(list)
    source.close
  }
}

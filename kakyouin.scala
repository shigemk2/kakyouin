import scala.io.Source

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var list = List.empty[Char]
    var rero = ""
    var j = 0
    source.foreach( { i =>
      if (i == " ") {
        list = i :: list
        rero = ""
      } else {
        rero += i
      }
      // println(i)
      // println(j)
      j += 1
    })
    println(j)
    println(list)
    source.close
  }
}

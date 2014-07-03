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
    while (i < array.length) {
      array(i) match {
        case "レロ" =>
          mem(curmem) -= 1
        case "レロレロ" =>
          mem(curmem) += 1
        case "レロレロレロ" =>
          curmem -= 1
        case "レロレロレロレロ" =>
          curmem += 1
        case "レロレロレロレロレロ" =>
          if (mem(curmem) != 0) {
            i = array.length + 1
          }
          nest = 0
          while (i < array.length) {
            if (array(i) == "レロレロレロレロレロ") {
              nest += 1
            } else if (array(i) == "レロレロレロレロレロレロ") {
              nest -= 1
              if (nest == 0) {
                i = array.length + 1
              }
            }
            i += 1
          }
        case "レロレロレロレロレロレロ" =>
          if (mem(curmem) == 0)  {
            i = array.length + 1
          }
          nest = 0
          while (i >= 0) {
            if (array(i) == "レロレロレロレロレロレロ") {
              nest += 1
            } else if (array(i) == "レロレロレロレロレロ") {
              nest -= 1
              if (nest == 0)  {
                i = array.length + 1
              }
            }
            i -= 1
          }
        case "レ" =>
          printf("%s", mem(curmem))
        case "ロ" =>
          mem(curmem) += array(i).asInstanceOf[Int]
      }

      i += 1
    }
    source.close
  }
}

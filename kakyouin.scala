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
      println(array(i))
      i += 1
    }
      // switch(j) {
      //   case "レロ" =>
      //     mem[curmem] -= 1
      //   case "レロレロ" =>
      //     mem[curmem] += 1
      //   case "レロレロレロ" =>
      //     curmem -= 1
      //   case "レロレロレロレロ" =>
      //     curmem += 1
      //   case "レロレロレロレロレロ" =>
      //     if (mem[curmem] != 0) break
      //     nest = 0
      //     while (i < len) {
      //       if (j == "レロレロレロレロレロ") {
      //         nest += 1
      //       } else if (j == "レロレロレロレロレロレロ") {
      //         nest -= 1
      //         if (nest == 0) break
      //       }
      //       i += 1
      //     }
      //   case "レロレロレロレロレロレロ" =>
      //     if (mem[curmem] == 0) break
      //     nest = 0
      //     while (i >= 0) {
      //       if (j == "レロレロレロレロレロレロ") {
      //         nest += 1
      //       } else if (j == "レロレロレロレロレロ") {
      //         nest -= 1
      //         if (nest == 0) break
      //       }
      //       i -= 1
      //     }
      //   case "レ" =>
      //     printf("%s", mem[curmem])
      //   case "ロ" =>
      //     mem[curmem] += j.asInstanceOf[Int]
      // }
    source.close
  }
}

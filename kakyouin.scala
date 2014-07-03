import scala.io.Source
import scala.util.control.Breaks

object kakyouin {
  def main(args: Array[String]) {
    var source = Source.fromFile("test.rero")
    var rero = ""
    var mem = new Array[Int](30000)
    var curmem = 0
    var i = 0
    var nest = 0
    val b = new Breaks

    source.foreach( { i =>
      rero += i
    })
    var array = rero.split("[\\s]+")
    while (i < array.length) {
      printf("i=%d bf[i]=%s curmem=%d mem[curmem]=%d nest=%d\n",
        i, array(i), curmem, mem(curmem), nest);
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
          b.breakable {
            if (mem(curmem) != 0) b.break
            nest = 0
            while (i < array.length) {
              if (array(i) == "レロレロレロレロレロ") {
                nest += 1
              } else if (array(i) == "レロレロレロレロレロレロ") {
                nest -= 1
                if (nest == 0) b.break
              }
              i += 1
            }
          }
        case "レロレロレロレロレロレロ" =>
          b.breakable {
            if (mem(curmem) == 0) b.break
            nest = 0
            while (i >= 0) {
              if (array(i) == "レロレロレロレロレロレロ") {
                nest += 1
              } else if (array(i) == "レロレロレロレロレロ") {
                nest -= 1
                if (nest == 0) b.break
              }
              i -= 1
            }
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

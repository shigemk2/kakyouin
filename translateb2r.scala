import java.io.PrintWriter
import scala.io.Source

object translateb2r {
  def main(args: Array[String]) {
    var source = Source.fromFile(args(0))
    val out = new PrintWriter(args(1))

    var rero = ""
    var i = 0

    source.foreach( { i =>
      rero += i + " "
    })
    var array = rero.split("[\\s]+")
    while (i < array.length) {
      array(i) match {
        case "-" =>
          out.print("レロ ")
        case "+" =>
          out.print("レロレロ ")
        case "<" =>
          out.print("レロレロレロ ")
        case ">" =>
          out.print("レロレロレロレロ ")
        case "[" =>
          out.print("レロレロレロレロレロ ")
        case "]" =>
          out.print("レロレロレロレロレロレロ ")
        case "." =>
          out.print("レ ")
        case "," =>
          out.print("ロ ")
        case _ =>
      }

      i += 1
    }
    source.close
    out.close
  }
}

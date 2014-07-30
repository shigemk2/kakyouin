import java.io.PrintWriter
import scala.io.Source

object bftranslate {

  def main(args: Array[String]) {
    var source = Source.fromFile(args(0))
    var out = new PrintWriter(args(1))
    var i = 0
    var bf = ""
    var count = 1

    out.print("object main {\n")
    out.print("def main(args: Array[String]) {\n")
    out.print("var mem = new Array[Int](30000)\n")
    out.print("var r = 0\n")

    source.foreach( { i =>
      bf += i + " "
    })

    val array = bf.split("[\\s]+")

    while (i < array.length) {
      array(i) match {
        case "+" =>
          if (i > 0 && array(i-1) == array(i)) {
            count += 1
          } else {
            count = 1
          }
          if (array(i) != array(i+1)) {
            out.print("mem(r) += "+count+" // +\n")
          }
        case "-" =>
          if (i > 0 && array(i-1) == array(i)) {
            count += 1
          } else {
            count = 1
          }
          if (array(i) != array(i+1)) {
            out.print("mem(r) -= "+count+" // -\n")
          }
        case ">" =>
          if (i > 0 && array(i-1) == array(i)) {
            count += 1
          } else {
            count = 1
          }
          if (array(i) != array(i+1)) {
            out.print("r += "+count+" // >\n")
          }
        case "<" =>
          if (i > 0 && array(i-1) == array(i)) {
            count += 1
          } else {
            count = 1
          }
          if (array(i) != array(i+1)) {
            out.print("r -= "+count+" // <\n")
          }
        case "[" =>
          out.print("while (mem(r) > 0) { // [\n")
        case "]" =>
          out.print("} // ]\n")
        case "." =>
          out.print("print(mem(r).asInstanceOf[Char]) // .\n")
        case "," =>
          out.print("mem(r) = Console.in.read // ,\n")
        case _ =>
      }
      i += 1
    }

    out.print("}\n");
    out.print("}\n");

    source.close
    out.close
  }
}

import java.io.PrintWriter
import scala.io.Source

object bftranslate {

  def main(args: Array[String]) {
    var source = Source.fromFile(args(0))
    var out = new PrintWriter(args(1))
    var i = 0
    var bf = ""

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
          out.print("mem(r) += 1 // +\n")
        case "-" =>
          out.print("mem(r) -= 1 // -\n")
        case ">" =>
          out.print("r += 1 // > \n")
        case "<" =>
          out.print("r -= 1 // < \n")
        case "[" =>
          out.print("while (mem(r) > 0) { // [\n")
        case "]" =>
          out.print("} // ]\n")
        case "." =>
          out.print("print(mem(r).asInstanceOf[Char]) // .\n")
        case "," =>
          out.print("mem(r) = Console.in.read // ,\n")
      }
      i += 1
    }

    out.print("}\n");
    out.print("}\n");

    source.close
    out.close
  }
}

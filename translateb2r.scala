import java.io.PrintWriter

object translateb2k {
  def main(args: Array[String]) {
    val out = new PrintWriter(args(0))
    out.println("Hello World!")
    out.close
  }
}

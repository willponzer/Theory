// caesarCipher.scala

object CaesarCipher {

  def encrypt(str: String, shift: Int): String = {
    // Convert to uppercase and shift each letter.
    str.toUpperCase.map { c =>
      if (c >= 'A' && c <= 'Z')
        (((c - 'A' + shift) % 26) + 'A').toChar
      else
        c
    }
  }

  def decrypt(str: String, shift: Int): String = {
    val adjShift = (26 - (shift % 26)) % 26
    encrypt(str, adjShift)
  }

  def solve(str: String, maxShift: Int): Unit = {
    for (shift <- 0 to maxShift) {
      println(s"Caesar $shift: " + decrypt(str, shift))
    }
  }

  def main(args: Array[String]): Unit = {
    println("Select operation: 1) Encrypt   2) Decrypt   3) Solve")
    val option = scala.io.StdIn.readInt()
    option match {
      case 1 =>
        println("Enter string to encrypt:")
        val inputStr = scala.io.StdIn.readLine()
        println("Enter shift value:")
        val shift = scala.io.StdIn.readInt()
        val result = encrypt(inputStr, shift)
        println("Encrypted string: " + result)
      case 2 =>
        println("Enter string to decrypt:")
        val inputStr = scala.io.StdIn.readLine()
        println("Enter shift value:")
        val shift = scala.io.StdIn.readInt()
        val result = decrypt(inputStr, shift)
        println("Decrypted string: " + result)
      case 3 =>
        println("Enter cipher text:")
        val inputStr = scala.io.StdIn.readLine()
        println("Enter maximum shift value:")
        val maxShift = scala.io.StdIn.readInt()
        solve(inputStr, maxShift)
      case _ =>
        println("Invalid option. Exiting.")
    }
  }
}

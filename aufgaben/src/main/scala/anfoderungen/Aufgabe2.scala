package anfoderungen

import scala.io.StdIn

class Aufgabe2 {

  def readInput(prompt: String): String = {
    println(prompt)
    StdIn.readLine()
  }

  def scoreWord(word: String): Int = {
    word.toLowerCase.toList match {
      case Nil => 0
      case head :: tail =>
        val point = if (head == 'a') 0 else 1
        point + scoreWord(tail.mkString)
    }
  }

  def insertSorted(word: String, list: List[String]): List[String] = {
    list match {
      case Nil => List(word)

      case head :: tail =>
        if (scoreWord(word) >= scoreWord(head))
          word :: list
        else
          head :: insertSorted(word, tail)
    }
  }

  def sortWords(words: List[String]): List[String] = {
    words match {
      case Nil => Nil
      case head :: tail =>
        insertSorted(head, sortWords(tail))
    }
  }

  def formatWords(words: List[String]): String = {
    words match {
      case Nil => "Keine Wörter vorhanden."
      case _ =>
        sortWords(words)
          .map(w => s"$w (${scoreWord(w)})")
          .mkString("\n")
    }
  }

  def menu(words: List[String]): Unit = {

    println(
      """
        |--- Wörter Bewertung ---
        |1. Wort hinzufügen
        |2. Wörter anzeigen (sortiert)
        |3. Exit
        |""".stripMargin
    )

    val choice = readInput("Auswahl eingeben:")

    choice match {

      case "1" =>
        val word = readInput("Wort eingeben:")
        menu(words :+ word)

      case "2" =>
        println(formatWords(words))
        menu(words)

      case "3" =>
        println("Programm beendet.")

      case _ =>
        println("Ungültige Eingabe.")
        menu(words)
    }
  }
}

object MainB {
  def main(args: Array[String]): Unit = {
    val wordScoreApp = new Aufgabe2();

    println("Willkommen zur Wörter-Bewertung App")
    wordScoreApp.menu(List.empty[String])
  }
}
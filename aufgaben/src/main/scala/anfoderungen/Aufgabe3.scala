package anfoderungen

import scala.io.StdIn

class Aufgabe3 {
  def readInput(prompt: String): String = {
    println(prompt)
    StdIn.readLine()
  }

  def readLaps(n: Int, acc: List[Double]): List[Double] = {
    if (n == 0) acc
    else {
      val time = readInput(s"Rundenzeit eingeben (Runde ${acc.length + 1}):").toDouble
      readLaps(n - 1, acc :+ time)
    }
  }

  def sum(times: List[Double]): Double = times match {
    case Nil => 0.0
    case head :: tail => head + sum(tail)
  }

  def average(times: List[Double]): Double = {
    times match {
      case Nil => 0.0
      case _ => sum(times) / times.length
    }
  }

  def formatResult(times: List[Double]): String = {
    val total = sum(times)
    val avg = average(times)

    s"""
       |--- Renn Ergebnis ---
       |Runden (ohne Warm-up): ${times.mkString(", ")}
       |Gesamtzeit: $total
       |Durchschnitt: $avg
       |""".stripMargin
  }

  def menu(): Unit = {

    println(
      """
        |--- Autorennen App ---
        |1. Rennen eingeben
        |2. Exit
        |""".stripMargin
    )

    val choice = readInput("Auswahl:")

    choice match {

      case "1" =>
        val count = readInput("Anzahl Runden inkl. Warm-up:").toInt

        val allLaps = readLaps(count, List.empty[Double])

        val lapsWithoutWarmup =
          allLaps.drop(1)

        println(formatResult(lapsWithoutWarmup))

        menu()

      case "2" =>
        println("Programm beendet.")

      case _ =>
        println("Ungültige Eingabe.")
        menu()
    }
  }
}

object MainC {
  def main(args: Array[String]): Unit = {
    val careRaceApp = new Aufgabe3();

    println("Willkommen zum Autorennen!")
    careRaceApp.menu()
  }
}
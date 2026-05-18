package anfoderungen

import scala.io.StdIn

class Aufgabe1 {
  def readInput(prompt: String): String = {
    println(prompt)
    StdIn.readLine()
  }

  def addDestination(route: List[String], destination: String): List[String] = {
    route :+ destination
  }

  def updateDestination(route: List[String], index: Int, newDestination: String): List[String] = {
    route.zipWithIndex.map {
      case (dest, i) =>
        if (i == index) newDestination else dest
    }
  }

  def formatRoute(route: List[String]): String = {
    if (route.isEmpty) "Route ist leer."
    else route.mkString(" -> ")
  }

  def menu(route: List[String]): Unit = {

    println(
      """
        |--- Reise Menü ---
        |1. Route hinzufügen
        |2. Route anzeigen
        |3. Route verändern
        |4. Exit
        |""".stripMargin
    )

    val choice = readInput("Auswahl eingeben:")

    choice match {

      case "1" =>
        val dest = readInput("Destination eingeben:")
        val newRoute = addDestination(route, dest)
        menu(newRoute)

      case "2" =>
        println(formatRoute(route))
        menu(route)

      case "3" =>
        val index = readInput("Index der Destination:")
        val newDest = readInput("Neue Destination:")

        val updatedRoute =
          updateDestination(route, index.toInt, newDest)

        menu(updatedRoute)

      case "4" =>
        println("Programm beendet.")

      case _ =>
        println("Ungültige Eingabe.")
        menu(route)
    }
  }
}

object MainA {
  def main(args: Array[String]): Unit = {
    val app = new Aufgabe1();

    println("Willkommen zur Reiseplanung App")
    app.menu(List.empty[String])
  }
}
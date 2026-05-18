package pure_functions

class Aufgabe3 {

  // -----------------------------
  // 3.1 Summe einer Liste (rekursiv)
  // -----------------------------
  def sumList(numbers: List[Int]): Int = numbers match {
    case Nil => 0
    case head :: tail => head + sumList(tail)
  }

  // -----------------------------
  // 3.2 Mittelwert einer Liste (rekursiv über Hilfsfunktionen)
  // -----------------------------
  def sumListForAvg(numbers: List[Int]): Int = numbers match {
    case Nil => 0
    case head :: tail => head + sumListForAvg(tail)
  }

  def lengthList(numbers: List[Int]): Int = numbers match {
    case Nil => 0
    case _ :: tail => 1 + lengthList(tail)
  }

  def average(numbers: List[Int]): Double = {
    numbers match {
      case Nil => 0.0
      case _ =>
        sumListForAvg(numbers).toDouble / lengthList(numbers)
    }
  }

  // -----------------------------
  // 3.3 Alphabetische Sortierung (rekursives Insertion Sort)
  // -----------------------------
  def insertSortedString(x: String, sorted: List[String]): List[String] = sorted match {
    case Nil => List(x)
    case head :: tail =>
      if (x <= head) x :: sorted
      else head :: insertSortedString(x, tail)
  }

  def sortStrings(list: List[String]): List[String] = list match {
    case Nil => Nil
    case head :: tail =>
      insertSortedString(head, sortStrings(tail))
  }

  // -----------------------------
  // 3.4 Sortierung von Objekten (Datum, Priorität, Titel)
  // -----------------------------
  case class Task(date: String, priority: Int, title: String)

  def isBefore(a: Task, b: Task): Boolean = {
    if (a.date != b.date) a.date < b.date
    else if (a.priority != b.priority) a.priority < b.priority
    else a.title < b.title
  }

  def insertTaskSorted(task: Task, list: List[Task]): List[Task] = list match {
    case Nil => List(task)
    case head :: tail =>
      if (isBefore(task, head)) task :: list
      else head :: insertTaskSorted(task, tail)
  }

  def sortTasks(list: List[Task]): List[Task] = list match {
    case Nil => Nil
    case head :: tail =>
      insertTaskSorted(head, sortTasks(tail))
  }

  // -----------------------------
  // 3.5 Baumstruktur → alle Blätter extrahieren
  // -----------------------------
  sealed trait Tree
  case class Leaf(value: Int) extends Tree
  case class Node(children: List[Tree]) extends Tree

  def getLeaves(tree: Tree): List[Int] = tree match {
    case Leaf(value) => List(value)
    case Node(children) =>
      children.flatMap(getLeaves)
  }
}
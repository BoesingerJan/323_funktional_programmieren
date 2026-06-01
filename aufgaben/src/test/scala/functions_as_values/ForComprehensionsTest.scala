package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class ForComprehensionsTest extends AnyFunSuite {

  val comp = new ForComprehensions()

  test("Exercise 1: squareNumbers") {
    val expected = List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
    assert(comp.squareNumbers() == expected)
  }

  test("Exercise 2: evenNumbers") {
    val expected = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
    assert(comp.evenNumbers() == expected)
  }

  test("Exercise 3: combineColorsAndFruits") {
    val colors = List("Red", "Green", "Blue")
    val fruits = List("Apple", "Banana", "Orange")
    val expected = List(
      ("Red", "Apple"), ("Red", "Banana"), ("Red", "Orange"),
      ("Green", "Apple"), ("Green", "Banana"), ("Green", "Orange"),
      ("Blue", "Apple"), ("Blue", "Banana"), ("Blue", "Orange")
    )
    assert(comp.combineColorsAndFruits(colors, fruits) == expected)
  }

  test("Exercise 4: pendingTasks") {
    val users = List(
      User("Alice", List("Task 1", "Task 2", "Task 3")),
      User("Bob", List("Task 1", "Task 4", "Task 5")),
      User("Charlie", List("Task 2", "Task 3", "Task 6"))
    )
    val tasksCompleted = List("Task 1", "Task 3", "Task 5")
    val expected = List(
      ("Alice", "Task 2"),
      ("Bob", "Task 4"),
      ("Charlie", "Task 2"),
      ("Charlie", "Task 6")
    )
    assert(comp.pendingTasks(users, tasksCompleted) == expected)
  }
}
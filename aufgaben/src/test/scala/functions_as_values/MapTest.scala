package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class MapTest extends AnyFunSuite {

  val exercises = new MapExercises()

  test("Exercise 1: doubleNumbers should double every integer in the list") {
    val input = List(1, 2, 3, 4, 5)
    val expected = List(2, 4, 6, 8, 10)
    assert(exercises.doubleNumbers(input) == expected)
  }

  test("Exercise 2: convertToUppercase should turn all strings to uppercase") {
    val input = List("Alice", "Bob", "Charlie")
    val expected = List("ALICE", "BOB", "CHARLIE")
    assert(exercises.convertToUppercase(input) == expected)
  }

  test("Exercise 3: halveNumbers should return accurate half values as doubles") {
    val input = List(12, 45, 68, 100)
    val expected = List(6.0, 22.5, 34.0, 50.0)
    assert(exercises.halveNumbers(input) == expected)
  }

  test("Exercise 4: formatAddresses should format Address objects into correct strings") {
    val input = List(
      Address("Hauptstrasse", 10, "12345", "Musterstadt"),
      Address("Nebenstrasse", 5, "23456", "Beispielburg")
    )
    val expected = List(
      "Hauptstrasse 10, 12345 Musterstadt",
      "Nebenstrasse 5, 23456 Beispielburg"
    )
    assert(exercises.formatAddresses(input) == expected)
  }

  test("Exercise 5: extractFirstNamesInUppercase should extract the first name and uppercase it") {
    val input = List("Max Mustermann", "Erika Mustermann")
    val expected = List("MAX", "ERIKA")
    assert(exercises.extractFirstNamesInUppercase(input) == expected)
  }
}
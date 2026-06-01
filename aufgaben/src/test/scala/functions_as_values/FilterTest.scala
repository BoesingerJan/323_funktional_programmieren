package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class FilterTest extends AnyFunSuite {

  val filter = new Filter()

  test("Exercise 1: filterEven") {
    val input = List(1, 2, 3, 4, 5)
    val expected = List(2, 4)
    assert(filter.filterEven(input) == expected)
  }

  test("Exercise 2: filterLongNames") {
    val input = List("Alice", "Bob", "Charlie", "Diana")
    val expected = List("Alice", "Charlie", "Diana")
    assert(filter.filterLongNames(input) == expected)
  }

  test("Exercise 3: filterGreaterThan50") {
    val input = List(12, 45, 68, 100)
    val expected = List(68, 100)
    assert(filter.filterGreaterThan50(input) == expected)
  }

  test("Exercise 4: filterStartsWithS") {
    val input = List("Scala", "ist", "fantastisch")
    val expected = List("Scala")
    assert(filter.filterStartsWithS(input) == expected)
  }

  test("Exercise 5: titlesBefore1950") {
    val input = List(
      Book("1984", "George Orwell", 1949),
      Book("Brave New World", "Aldous Huxley", 1932),
      Book("Fahrenheit 451", "Ray Bradbury", 1953)
    )
    val expected = List("1984", "Brave New World")
    assert(filter.titlesBefore1950(input) == expected)
  }
}
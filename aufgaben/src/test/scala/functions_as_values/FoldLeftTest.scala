package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class FoldLeftTest extends AnyFunSuite {

  val folder = new FoldLeft()

  test("Exercise 1: sumList") {
    val input = List(1, 2, 3, 4, 5)
    assert(folder.sumList(input) == 15)
  }

  test("Exercise 2: combineStrings") {
    val input = List("Hallo", " ", "Welt", "!")
    assert(folder.combineStrings(input) == "Hallo Welt!")
  }

  test("Exercise 3: calculateCentroid") {
    val input = List((1, 3), (2, 5), (4, 8), (6, 2))
    val expected = (3.25, 4.5)
    assert(folder.calculateCentroid(input) == expected)
  }
}
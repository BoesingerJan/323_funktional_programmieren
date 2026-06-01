package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class FlatMapTest extends AnyFunSuite {

  val mapper = new FlatMap()

  test("Exercise 1: flattenAndDouble") {
    val input = List(List(1, 2), List(3, 4), List(5, 6))
    val expected = List(2, 4, 6, 8, 10, 12)
    assert(mapper.flattenAndDouble(input) == expected)
  }

  test("Exercise 2: uniqueFavoriteColors") {
    val input = List(
      ("Max", List("Blau", "Grün")),
      ("Anna", List("Rot")),
      ("Julia", List("Gelb", "Blau", "Grün"))
    )
    val expected = List("Blau", "Grün", "Rot", "Gelb")
    assert(mapper.uniqueFavoriteColors(input) == expected)
  }
}
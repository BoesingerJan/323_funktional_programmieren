package functions_as_values

import org.scalatest.funsuite.AnyFunSuite

class MapAndFilterTest extends AnyFunSuite {

  val mapAndFilter = new MapAndFilter()

  test("doubleEvenNumbers should filter items to even status then double them") {
    val input = List(1, 2, 3, 4, 5)
    val expected = List(4, 8)
    assert(mapAndFilter.doubleEvenNumbers(input) == expected)
  }

  test("uppercaseShortStrings should slice long items away and uppercase the remainder") {
    val input = List("apple", "go", "scala", "hi")
    val expected = List("GO", "HI")
    assert(mapAndFilter.uppercaseShortStrings(input, 3) == expected)
  }
}
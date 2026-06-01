package einfuehrung

import einfuehrung.Imperative1
import org.scalatest.funsuite.AnyFunSuite

class Imperative1Test extends AnyFunSuite {

  test("calculateScore counts all non-'a' characters") {
    assert(Imperative1.calculateScore("hello") == 5)
    assert(Imperative1.calculateScore("banana") == 3)
    assert(Imperative1.calculateScore("aaaa") == 0)
    assert(Imperative1.calculateScore("") == 0)
  }
}
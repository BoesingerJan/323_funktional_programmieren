package pure_functions

import scala.collection.mutable.ListBuffer
import scala.util.Random

class Aufgabe2 {
  // 1.1

  // 1.1 impure version
  val cartItems = ListBuffer[String]()

  def addToCart(item: String): List[String] = {
    cartItems += item
    cartItems.toList
  }

  // 1.1 pure version
  def addToCart(cartItems: List[String], item: String): List[String] = {
    cartItems :+ item
  }



  // 1.4

  // 1.4 impure version
  def multiplyWithRandom(number: Double): Double = {
    val randomValue = Random.nextDouble()
    number * randomValue
  }

  // 1.4 pure version
  def multiplyWithRandom(number: Double, randomValue: Double): Double = {
    number * randomValue
  }



  // 1.6

  // 1.6 impure version
  def printAndReturnString(str: String): String = {
    println(str)
    str
  }

  // 1.6 pure version
  def returnString(str: String): String = {
    str
  }
}
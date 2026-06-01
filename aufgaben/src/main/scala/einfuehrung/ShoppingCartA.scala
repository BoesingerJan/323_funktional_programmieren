package einfuehrung

import java.util.Scanner

val scanner = new Scanner(System.in)

class ShoppingCartA {
  private var shoppingCart = Array[String]()
  private var hasBook = false
  private var running = true

  while (running) {

    println(
      "\n1 -> add item to cart\n" +
        "2 -> remove item from cart\n" +
        "3 -> show cart\n" +
        "4 -> exit\n"
    )

    print("choose action: ")

    try {
      val chosenAction = scanner.nextInt()

      chosenAction match
        case 1 => addItem()
        case 2 => removeItem()
        case 3 => showCart()
        case 4 => exitProgram()
        case _ => displayError()

    } catch {
      case _: Exception =>
        println("Invalid input. Please enter a number.")
        scanner.nextLine()
    }
  }

  private def addItem(): Unit = {
    try {
      scanner.nextLine()

      print("Enter item: ")
      val item = scanner.nextLine()

      if (item.trim.isEmpty) {
        println("Item name cannot be empty")
        return
      }

      shoppingCart = shoppingCart :+ item

      if (item.contains("Book") || item.contains("book")) {
        hasBook = true
      }

      println(item + " added")
      showCart()
    } catch {

      case _: Exception =>
        println("Error while adding item")
    }
  }

  private def removeItem(): Unit = {
    try {
      scanner.nextLine()

      if (shoppingCart.length == 0) {
        println("Cart is empty")
        return
      }

      print("Enter item to remove: ")
      val item = scanner.nextLine()

      if (item.trim.isEmpty) {
        println("Item name cannot be empty")
        return
      }

      var itemFound = false
      var newCart = Array[String]()

      for (cartItem <- shoppingCart) {

        if (cartItem != item) {
          newCart = newCart :+ cartItem
        } else {
          itemFound = true
        }
      }

      if (!itemFound) {
        println("Item not found in cart")
        return
      }

      shoppingCart = newCart

      hasBook = false

      for (cartItem <- shoppingCart) {
        if (cartItem == "Book") {
          hasBook = true
        }
      }

      println(item + " removed")
      showCart()
    } catch {

      case _: Exception =>
        println("Error while removing item")
    }
  }

  private def showCart(): Unit = {
    println("\nShopping cart:")

    if (shoppingCart.length == 0) {
      println("Cart is empty")
    } else {

      for (item <- shoppingCart) {
        println("- " + item)
      }
    }

    if (hasBook) {
      println("Discount: 5%")
    } else {
      println("Discount: 0%")
    }
  }

  private def exitProgram(): Unit = {
    running = false
    println("Program ended")
  }

  private def displayError(): Unit = {
    println("Please choose a valid action")
  }
}

object MainA {
  def main(args: Array[String]): Unit = {
    new ShoppingCartA()
  }
}
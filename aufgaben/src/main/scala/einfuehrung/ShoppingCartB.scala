package einfuehrung

class ShoppingCartB {
  private var items   = List[String]()
  private var running = true

  private def calculateDiscount(cart: List[String]): Double =
    if (cart.exists(_.contains("Book")) || cart.exists(_.contains("book"))) 0.05 else 0.0

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

      if (item.trim.isEmpty) { println("Item name cannot be empty"); return }

      items = items :+ item
      println(s"$item added")
      showCart()
    } catch {
      case _: Exception => println("Error while adding item")
    }
  }

  private def removeItem(): Unit = {
    try {
      scanner.nextLine()

      if (items.isEmpty) { println("Cart is empty"); return }

      print("Enter item to remove: ")
      val item = scanner.nextLine()

      if (item.trim.isEmpty) { println("Item name cannot be empty"); return }

      val newItems = items.filterNot(_ == item)

      if (newItems.length == items.length) { println("Item not found in cart"); return }

      items = newItems
      println(s"$item removed")
      showCart()
    } catch {
      case _: Exception => println("Error while removing item")
    }
  }

  private def showCart(): Unit = {
    println("\nShopping cart:")
    if (items.isEmpty) println("Cart is empty")
    else items.foreach(item => println(s"- $item"))

    val discount = calculateDiscount(items)
    println(f"Discount: ${discount * 100}%.0f%%")
  }

  private def exitProgram(): Unit = { running = false; println("Program ended") }
  private def displayError(): Unit = println("Please choose a valid action")
}

object MainB {
  def main(args: Array[String]): Unit = {
    new ShoppingCartB()
  }
}
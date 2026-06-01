package einfuehrung

case class Cart(items: List[String] = List.empty) {
  def addItem(item: String): Cart =
    copy(items = items :+ item)

  def removeItem(item: String): Cart = {
    val index = items.indexOf(item)
    if (index < 0) this
    else copy(items = items.patch(index, Nil, 1))
  }

  def discount: Double =
    if (items.exists(_.contains("Book")) || items.exists(_.contains("book"))) 0.05 else 0.0

  def display(): Unit = {
    println("\nShopping cart:")
    if (items.isEmpty) println("Cart is empty")
    else items.foreach(item => println(s"- $item"))
    println(f"Discount: ${discount * 100}%.0f%%")
  }
}

class ShoppingCartC {
  private var cart    = Cart()
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
        case 3 => cart.display()
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

      cart = cart.addItem(item)
      println(s"$item added")
      cart.display()
    } catch {
      case _: Exception => println("Error while adding item")
    }
  }

  private def removeItem(): Unit = {
    try {
      scanner.nextLine()

      if (cart.items.isEmpty) { println("Cart is empty"); return }

      print("Enter item to remove: ")
      val item = scanner.nextLine()

      if (item.trim.isEmpty) { println("Item name cannot be empty"); return }

      val newCart = cart.removeItem(item)

      if (newCart == cart) { println("Item not found in cart"); return }

      cart = newCart
      println(s"$item removed")
      cart.display()
    } catch {
      case _: Exception => println("Error while removing item")
    }
  }

  private def exitProgram(): Unit = { running = false; println("Program ended") }
  private def displayError(): Unit = println("Please choose a valid action")
}


object Main {
  def main(args: Array[String]): Unit = {
    new ShoppingCartC()
  }
}
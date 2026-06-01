package functions_as_values

case class User(name: String, tasks: List[String])

class ForComprehensions {

  def squareNumbers(): List[Int] = {
    for {
      n <- (1 to 10).toList
    } yield n * n
  }

  def evenNumbers(): List[Int] = {
    for {
      n <- (1 to 20).toList
      if n % 2 == 0
    } yield n
  }

  def combineColorsAndFruits(colors: List[String], fruits: List[String]): List[(String, String)] = {
    for {
      c <- colors
      f <- fruits
    } yield (c, f)
  }

  def pendingTasks(users: List[User], completedTasks: List[String]): List[(String, String)] = {
    for {
      u <- users
      t <- u.tasks
      if !completedTasks.contains(t)
    } yield (u.name, t)
  }
}
package functions_as_values

case class Book(title: String, author: String, year: Int)

class Filter {

  def filterEven(numbers: List[Int]): List[Int] = {
    numbers.filter(_ % 2 == 0)
  }

  def filterLongNames(names: List[String]): List[String] = {
    names.filter(_.length > 4)
  }

  def filterGreaterThan50(numbers: List[Int]): List[Int] = {
    numbers.filter(_ > 50)
  }

  def filterStartsWithS(words: List[String]): List[String] = {
    words.filter(_.startsWith("S"))
  }

  def titlesBefore1950(books: List[Book]): List[String] = {
    books.filter(_.year < 1950).map(_.title)
  }
}
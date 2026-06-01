package functions_as_values

case class Address(street: String, houseNumber: Int, zipCode: String, city: String)

class MapExercises {
  def doubleNumbers(numbers: List[Int]): List[Int] = {
    numbers.map(n => n * 2)
  }

  def convertToUppercase(names: List[String]): List[String] = {
    names.map(name => name.toUpperCase)
  }

  def halveNumbers(numbers: List[Int]): List[Double] = {
    numbers.map(n => n / 2.0)
  }

  def formatAddresses(addresses: List[Address]): List[String] = {
    addresses.map(a => s"${a.street} ${a.houseNumber}, ${a.zipCode} ${a.city}")
  }

  def extractFirstNamesInUppercase(names: List[String]): List[String] = {
    names.map(name => name.split(" ").head.toUpperCase)
  }
}
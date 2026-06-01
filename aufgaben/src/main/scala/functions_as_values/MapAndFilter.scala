package functions_as_values

class MapAndFilter {

  def doubleEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(n => n % 2 == 0).map(n => n * 2)
  }

  def uppercaseShortStrings(strings: List[String], maxLength: Int): List[String] = {
    strings.filter(s => s.length <= maxLength).map(s => s.toUpperCase)
  }
}
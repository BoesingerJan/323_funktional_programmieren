package functions_as_values

class FlatMap {

  def flattenAndDouble(lists: List[List[Int]]): List[Int] = {
    lists.flatMap(subList => subList.map(_ * 2))
  }

  def uniqueFavoriteColors(people: List[(String, List[String])]): List[String] = {
    people.flatMap(_._2).distinct
  }
}
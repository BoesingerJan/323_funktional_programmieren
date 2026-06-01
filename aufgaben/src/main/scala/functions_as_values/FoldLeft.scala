package functions_as_values

class FoldLeft {

  def sumList(numbers: List[Int]): Int = {
    numbers.foldLeft(0)(_ + _)
  }

  def combineStrings(strings: List[String]): String = {
    strings.foldLeft("")(_ + _)
  }

  def calculateCentroid(points: List[(Int, Int)]): (Double, Double) = {
    val (sumX, sumY) = points.foldLeft((0.0, 0.0)) { (acc, point) =>
      (acc._1 + point._1, acc._2 + point._2)
    }
    (sumX / points.length, sumY / points.length)
  }
}
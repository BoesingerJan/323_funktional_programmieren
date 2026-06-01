package einfuehrung

object Imperative1 {
  def calculateScore(word: String): Int = {
    var score = 0
    for (c <- word.toCharArray) {
      if (c != 'a') {
        score += 1
      }
    }
    score
  }
}
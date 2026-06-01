package einfuehrung

object Declarative1 {
  def wordScore(word: String): Int = word.count(w => w != 'a')
}
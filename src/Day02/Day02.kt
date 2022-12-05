package Day02

import java.io.File

fun main() {

    fun playResult(play: String): Int {
        val splitPlay = play.split(" ")
        val play = Play(splitPlay[0], splitPlay[1]);
        return play.selScore() + play.resScore()
    }

    fun playResultPart2(play: String): Int {
        val splitPlay = play.split(" ")
        val play = Play(splitPlay[0], splitPlay[1]);
        return play.selAndEndScore()
    }

    fun part1(input: String): Int {
        return input
            .lines()
            .fold(0) { acc, play -> acc + playResult(play) }
    }


    fun part2(input: String): Int {
        return input
            .lines()
            .fold(0) { acc, play -> acc + playResultPart2(play) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day02/Day02_test.txt").readText()
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = File("src/Day02/data.txt").readText()
    println(part1(input))
    println(part2(input))
}

class Play(val opponent: String, val you: String) {


    fun selScore(): Int {

        return when (you) {
            in "X" -> 1
            in "Y" -> 2
            in "Z" -> 3
            else -> 0
        }

    }

    fun resScore(): Int {

        return when (you) {
            in "X" -> when (opponent) {
                "A" -> 3
                "B" -> 0
                else -> 6
            }
            in "Y" -> when (opponent) {
                "A" -> 6
                "B" -> 3
                else -> 0
            }
            else -> when (opponent) {
                "A" -> 0
                "B" -> 6
                else -> 3
            }
        }
    }

    fun recScore(op: String, you: String): Int {
        val play = Play(op, you);
        return return play.selScore() + play.resScore()
    }

    fun selAndEndScore(): Int {

        return when (opponent) {

            in "A" -> when (you) {
                "X" -> recScore("A", "Z")
                "Y" -> recScore("A", "X")
                else -> recScore("A", "Y")
            }

            in "B" -> when (you) {
                "X" -> recScore("B", "X")
                "Y" -> recScore("B", "Y")
                else -> recScore("B", "Z")
            }

            else -> when (you) {
                "X" -> recScore("C", "Y")
                "Y" -> recScore("C", "Z")
                else -> recScore("C", "X")
            }
        }
    }
}

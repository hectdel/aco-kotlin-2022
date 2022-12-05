package Day03

import java.io.File

fun main() {

    val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun Char.toValue(): Int = chars.indexOf(this) + 1
    check('p'.toValue() == 16)
    check('L'.toValue() == 38)

    fun part1(input: String): Int {

        var commonChars = mutableListOf<Char>()
        input.lines()
            .map { it.substring(0, it.length.div(2)) to it.substring(it.length.div(2), it.length) }
            .map {
                it.first.iterator().forEach { char ->
                    if (it.second.contains(char)) {
                        commonChars.add(char)
                        return@map
                    }
                }
            }

        return commonChars.map { it.toValue() }.sum()
    }


    fun containsChar(c: Char, line:String):Boolean {
        return line.contains(c)
    }

    fun calculateResult(n: Int, input: String) : Int{

        val grouped = input
            .lines()
            .chunked(n)

        return grouped.sumOf {
            it.first()
                .toCharArray()
                .first { char -> IntRange(1, n - 1).all { n -> containsChar(char, it[n]) } }
                .toValue()
        }
    }

    fun part2(input: String): Int {
      return calculateResult(3, input)
    }

    val testInput = File("src/Day03/test_data.txt").readText()
    println(part1(testInput))
    check(part1(testInput) == 157)
    check(part2(testInput) == 70 )

    val input = File("src/Day03/data.txt").readText()
    println(part1(input))
    println(part2(input))

}



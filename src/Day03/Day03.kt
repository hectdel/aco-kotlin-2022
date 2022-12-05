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


    fun part2(input: String): Int {

        val acc = ""
        val grouped = input
            .lines()
            .take(3)

        val found = grouped.first().toCharArray().find { char -> grouped[1].contains(char) && grouped[2].contains(char) }

        println(found)
        return 0
    }


    val testInput = File("src/Day03/test_data.txt").readText()
    println(part1(testInput))
    check(part1(testInput) == 157)
    check(part2(testInput) == 70 )

    val input = File("src/Day03/data.txt").readText()
    println(part1(input))
    println(part2(input))

}



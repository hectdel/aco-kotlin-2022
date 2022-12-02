import java.io.File

fun main() {
    fun part1(input: String): Int {
        val data = input.split("\n\n").map { elf -> elf.lines().map { it.toInt() } }
        return data.maxOf { it.sum() }
    }

    fun part2(input: String): Int {
        val data = input.split("\n\n").map { elf -> elf.lines().map { it.toInt() } }
        val sortedList =  data.map { it.sum() }.sortedDescending()
        return sortedList.component1() + sortedList.component2() + sortedList.component3()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day01_test.txt").readText()
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input =  File("src/Day01.txt").readText()
    println(part1(input))
    println(part2(input))
}

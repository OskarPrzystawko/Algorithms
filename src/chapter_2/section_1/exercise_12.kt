package chapter_2.section_1

import kotlin.math.pow
import kotlin.random.Random

fun main() {
    val shellSort = DebugShellSort()

    for (size in getPowerSequence()) {
        val input = getRandomInput(size)
        shellSort.sort(input)
        require(input.isSorted())
    }
}

private fun getRandomInput(size: Int) = (1..size).map {
    Random.nextDouble()
}.toTypedArray()

private fun getPowerSequence() = (0..5).map {
    100 * 10.0.pow(it).toInt()
}

class DebugShellSort: SortBase() {
    private var compares = 0

    fun <T : Comparable<T>> sort(items: Array<T>) {
        val size = items.size
        var h = 1
        while (h < size/3) h = 3*h + 1

        while (h >= 1) {
            compares = 0
            for (i in h until size) {
                var j = i
                while (j >= h && less(items[j], items[j - h])) {
                    exchange(items, j, j - h)
                    j -= h
                }
            }
            println("h = $h | Compares $compares / array size ($size) = ${compares.toFloat() / size}")
            h /= 3
        }
    }

    override fun <T : Comparable<T>> less(a: T, b: T): Boolean {
        compares++
        return super.less(a, b)
    }
}
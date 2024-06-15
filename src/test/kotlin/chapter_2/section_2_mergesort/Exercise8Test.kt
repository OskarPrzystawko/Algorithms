package chapter_2.section_2_mergesort

import org.junit.jupiter.api.Test
import kotlin.math.ceil

class Exercise8Test {

    @Test
    fun `mergesort - exercise 8`() {
        val max = 2_000_000

        var i = 8
        while (i < max) {
            val topDownStats = Exercise8.topDownMergeSortTest(
                items = Array(i) { index -> index },
                comparator = { a, b -> a.compareTo(b) },
            )

            println("items: ${i.toString().padEnd(10)} | " +
                    "comparisons: ${topDownStats.comparisons.toString().padEnd(8)} | " +
                    "comparisons/items: ${ceil(topDownStats.comparisons.toDouble() / i)}")
            i *= 2
        }
    }
}
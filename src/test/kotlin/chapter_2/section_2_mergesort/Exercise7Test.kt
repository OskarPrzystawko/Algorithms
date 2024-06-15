package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.test.Stats
import chapter_2.section_2_mergesort.common.test.bottomUpMergeSortTest
import chapter_2.section_2_mergesort.common.test.topDownMergeSortTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.random.Random

@Disabled("Check Exercise 7")
class Exercise7Test {

    @Test
    fun `mergesort - exercise 7 - top-down mergesort`() {
        val MAX = 512
        val items = Array(MAX) { Random.nextInt() }
        var previousStats = Stats(-1,-1)

        for (i in 1..MAX) {
            val topDownStats = items.copyOfRange(0, i).topDownMergeSortTest(
                comparator = { a, b -> a.compareTo(b) },
            )
            println("items: ${i.toString().padEnd(6)} | " +
                    "top-down: ${topDownStats.comparisons.toString().padEnd(8)}")
            println(items.copyOfRange(0, i).contentToString())

            assertTrue(previousStats.comparisons < topDownStats.comparisons)
            previousStats = topDownStats
        }
    }

    @Test
    fun `mergesort - exercise 7 - bottom-up mergesort`() {
        val MAX = 512
        val items = Array(MAX) { Random.nextInt() }
        var previousStats = Stats(-1,-1)

        for (i in 1..MAX) {
            val topDownStats = items.copyOfRange(0, i).bottomUpMergeSortTest(
                comparator = { a, b -> a.compareTo(b) },
            )
            println("items: ${i.toString().padEnd(6)} | " +
                    "top-down: ${topDownStats.comparisons.toString().padEnd(8)}")

            assertTrue(previousStats.comparisons < topDownStats.comparisons)
            previousStats = topDownStats
        }
    }
}
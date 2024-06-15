package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.test.bottomUpMergeSortTest
import chapter_2.section_2_mergesort.common.test.topDownMergeSortTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.*
import kotlin.random.Random

class Exercise6Test {

    @Test
    fun `mergesort - exercise 6`() {
        for (i in 1..512) {
            val items = Array(i) { Random.nextInt() }
            val topDownStats = items.copyOf().topDownMergeSortTest(
                comparator = { a, b -> a.compareTo(b) },
            )
            val bottomUpStats = items.bottomUpMergeSortTest(
                comparator = { a, b -> a.compareTo(b) },
            )
            val upperBound = (6*i* ceil(log2(i.toFloat()))).toInt()
            println("items: ${i.toString().padEnd(6)} | " +
                    "top-down: ${topDownStats.arrayAccesses.toString().padEnd(8)} | " +
                    "bottom-up: ${bottomUpStats.arrayAccesses.toString().padEnd(8)} | " +
                    "6n*lg(n): $upperBound")
            assertTrue(topDownStats.arrayAccesses <= upperBound)
            assertTrue(bottomUpStats.arrayAccesses <= upperBound)
        }
    }
}
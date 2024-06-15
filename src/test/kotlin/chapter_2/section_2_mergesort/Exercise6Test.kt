package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.arrayaccess.bottomUpMergeSortArrayAccess
import chapter_2.section_2_mergesort.common.arrayaccess.topDownMergeSortArrayAccess
import chapter_2.section_2_mergesort.common.logs.bottomUpMergeSortWithLogs
import chapter_2.section_2_mergesort.common.logs.topDownMergeSortWithLogs
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.*
import kotlin.random.Random
import kotlin.random.nextInt

class Exercise6Test {

    @Test
    fun `mergesort - exercise 6`() {
        for (i in 1..512) {
            val items = Array(i) { Random.nextInt() }
            val topDownArrayAccesses = items.copyOf().topDownMergeSortArrayAccess(
                comparator = { a, b -> a.compareTo(b) },
            )
            val bottomUpArrayAccesses = items.bottomUpMergeSortArrayAccess(
                comparator = { a, b -> a.compareTo(b) },
            )
            val upperBound = (6*i* ceil(log2(i.toFloat()))).toInt()
            println("items: ${i.toString().padEnd(6)} | " +
                    "top-down: ${topDownArrayAccesses.toString().padEnd(8)} | " +
                    "bottom-up: ${bottomUpArrayAccesses.toString().padEnd(8)} | " +
                    "6n*lg(n): $upperBound")
            assertTrue(topDownArrayAccesses <= upperBound)
            assertTrue(bottomUpArrayAccesses <= upperBound)
        }
    }
}
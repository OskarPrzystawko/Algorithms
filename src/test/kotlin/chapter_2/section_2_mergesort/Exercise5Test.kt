package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.logs.bottomUpMergeSortWithLogs
import chapter_2.section_2_mergesort.common.logs.topDownMergeSortWithLogs
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise5Test {

    @Test
    fun `mergesort - exercise 5`() {
        // GIVEN
        val items = Array(size = 39) { 1 }

        // WHEN
        println("Subarray lengths in the merges")
        println("Top-down merge sort")
        //
        items.topDownMergeSortWithLogs(
            comparator = { a, b -> a.compareTo(b) },
            afterMerge = { _, _, low, _, high, _ ->
                print("${high-low+1}, ")
            }
        )
        println()
        println("Bottom-up merge sort")
        items.bottomUpMergeSortWithLogs(
            comparator = { a, b -> a.compareTo(b) },
            afterMerge = { _, _, low, _, high, _ ->
                print("${high-low+1}, ")
            }
        )
        println()

        // THEN
        val expectedItems = Array(39) { 1 }
        assertArrayEquals(expectedItems, items)
    }
}
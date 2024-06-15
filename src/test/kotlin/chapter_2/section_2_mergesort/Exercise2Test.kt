package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.logs.topDownMergeSortWithLogs
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise2Test {

    @Test
    fun `mergesort - exercise 2`() {
        // GIVEN
        val items = arrayOf('E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N')

        // WHEN
        with(items.contentToString()) {
            println(padStart(length + MERGE_STRING_LENGTH))
        }
        items.topDownMergeSortWithLogs(
            comparator = { a, b -> a.compareTo(b) },
            afterMerge = { _, _, low, mid, high, depth ->
                val str = "merge(low = $low, mid = $mid, high = $high)"
                print(str.padStart(str.length + 2*depth).padEnd(MERGE_STRING_LENGTH))
                println(items.contentToString())
            }
        )

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

    companion object {
        private const val MERGE_STRING_LENGTH = 48
    }
}
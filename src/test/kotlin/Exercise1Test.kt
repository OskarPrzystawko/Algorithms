package test

import chapter_2.section_2_mergesort.Exercise1.merge
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise1Test {

    @Test
    fun `merge() merges 2 sorted halves of the array into 1 sorted array`() {
        // GIVEN
        val items = arrayOf('A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S', 'T')

        // WHEN
        items.merge(
            memory = Array(items.size, init = { null }),
            comparator = { a, b -> a.compareTo(b) },
            low = 0,
            mid = (items.size - 1) / 2,
            high = items.size - 1,
        )

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

}
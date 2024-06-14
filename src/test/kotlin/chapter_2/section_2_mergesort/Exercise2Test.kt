package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.Exercise2.topDownMergeSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise2Test {

    @Test
    fun `sorts letters array`() {
        // GIVEN
        val items = arrayOf('E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N')

        // WHEN
        items.topDownMergeSort { a, b -> a.compareTo(b) }

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

    @Test
    fun `sorts integers array`() {
        // GIVEN
        val items = arrayOf(-1231, 1, 231433, 3, 5, 6, 7, 3, 2, 1, -10, 12, 213, 545, 231231)

        // WHEN
        items.topDownMergeSort { a, b -> a.compareTo(b) }

        // THEN
        val expectedItems = arrayOf(-1231, -10, 1, 1, 2, 3, 3, 5, 6, 7, 12, 213, 545, 231231, 231433)
        assertArrayEquals(expectedItems, items)
    }

}
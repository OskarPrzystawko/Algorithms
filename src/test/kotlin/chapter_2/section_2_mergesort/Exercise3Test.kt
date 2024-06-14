package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.Exercise3.bottomUpMergeSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise3Test {

    @Test
    fun `sorts letters array`() {
        // GIVEN
        val items = arrayOf('E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N')

        // WHEN
        items.bottomUpMergeSort { a, b -> a.compareTo(b) }

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

}
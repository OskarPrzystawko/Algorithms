package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.logs.mergeWithLogs
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Exercise1Test {

    @Test
    fun `mergesort - exercise 1`() {
        // GIVEN
        val items = arrayOf('A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S', 'T')

        // WHEN
        items.mergeWithLogs(
            memory = Array(items.size, init = { null }),
            comparator = { a, b -> a.compareTo(b) },
            low = 0,
            mid = (items.size - 1) / 2,
            high = items.size - 1,
            whileMerge = { memory, _, _, mid, high, _, index, l, r ->
                print(items.take(index).toString().padEnd(items.size * 3))
                print(memory.copyOfRange(l, mid + 1).contentToString().padStart(memory.size * 3 / 2))
                println(memory.copyOfRange(r, high + 1).contentToString().padStart(memory.size * 3 / 2))
            }
        )

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

}
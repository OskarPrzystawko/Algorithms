package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.logs.bottomUpMergeSortWithLogs
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.math.floor
import kotlin.math.log2

class Exercise3Test {

    @Test
    fun `mergesort - exercise 3`() {
        // GIVEN
        val items = arrayOf('E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N')

        // WHEN
        with(items.contentToString()) {
            println(padStart(length + MERGE_STRING_LENGTH))
        }
        val maxDepth = floor(log2((items.size-1).toDouble())).toInt()
        var depth = maxDepth
        items.bottomUpMergeSortWithLogs(
            comparator = { a, b -> a.compareTo(b) },
            onLengthChange = {
                depth = maxDepth - log2(it.toDouble()).toInt()
                with("Length = $it") {
                    println(padStart(length + depth*2))
                }
            },
            afterMerge = { _, _, low, mid, high, _ ->
                val str = "merge(low = $low, mid = $mid, high = $high)"
                print(str.padStart(str.length + depth*2).padEnd(MERGE_STRING_LENGTH))
                println(items.contentToString())
            }
        )
        println()

        // THEN
        val expectedItems = arrayOf('A', 'E', 'E', 'I', 'N', 'O', 'Q', 'S', 'S', 'T', 'U', 'Y')
        assertArrayEquals(expectedItems, items)
    }

    companion object {
        private const val MERGE_STRING_LENGTH = 48
    }

}
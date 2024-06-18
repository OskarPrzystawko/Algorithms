package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.Exercise10.fasterMerge
import chapter_2.section_2_mergesort.common.vanilla.merge
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class Exercise10Test {

    @Test
    fun `mergesort - exercise 10`() {
        // GIVEN
        val halfSize = 2048
        val sortedArrayA = Array(halfSize) { i -> i }
        val sortedArrayB = Array(halfSize) { i -> i*2 }
        val inputArray = sortedArrayA + sortedArrayB

        // WHEN
        val input = inputArray.copyOf()
        val mergeTime = measureNanoTime {
            with(input) {
                merge(
                    memory = Array(size, init = { null }),
                    comparator = { a, b -> a.compareTo(b) },
                    low = 0,
                    mid = (size - 1) / 2,
                    high = size - 1,
                )
            }
        }

        val fasterMergeTime = measureNanoTime {
            with(inputArray) {
                fasterMerge(
                    memory = Array(size, init = { null }),
                    comparator = { a, b -> a.compareTo(b) },
                    low = 0,
                    mid = (size - 1) / 2,
                    high = size - 1,
                )
            }
        }

        // THEN
        println("Merge time: $mergeTime | Faster merge time: $fasterMergeTime")
        assertTrue(fasterMergeTime < mergeTime)
    }
}
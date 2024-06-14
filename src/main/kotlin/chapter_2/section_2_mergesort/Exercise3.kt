package chapter_2.section_2_mergesort

import kotlin.math.floor
import kotlin.math.log2


/**
 * 2.2.3
 * Give traces, in the style of the trace given with ALGORITHM 2.4,
 * showing how the keys E A S Y Q U E S T I O N are sorted with bottom-up mergesort
 *
 *                                                 [E, A, S, Y, Q, U, E, S, T, I, O, N]
 *       Length = 1
 *       merge(low = 0, mid = 0, high = 1)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 2, mid = 2, high = 3)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 4, mid = 4, high = 5)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 6, mid = 6, high = 7)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 8, mid = 8, high = 9)         [A, E, S, Y, Q, U, E, S, I, T, O, N]
 *       merge(low = 10, mid = 10, high = 11)      [A, E, S, Y, Q, U, E, S, I, T, N, O]
 *     Length = 2
 *     merge(low = 0, mid = 1, high = 3)           [A, E, S, Y, Q, U, E, S, I, T, N, O]
 *     merge(low = 4, mid = 5, high = 7)           [A, E, S, Y, E, Q, S, U, I, T, N, O]
 *     merge(low = 8, mid = 9, high = 11)          [A, E, S, Y, E, Q, S, U, I, N, O, T]
 *   Length = 4
 *   merge(low = 0, mid = 3, high = 7)             [A, E, E, Q, S, S, U, Y, I, N, O, T]
 *   merge(low = 8, mid = 11, high = 11)           [A, E, E, Q, S, S, U, Y, I, N, O, T]
 * Length = 8
 * merge(low = 0, mid = 7, high = 11)              [A, E, E, I, N, O, Q, S, S, T, U, Y]
 */
object Exercise3 {

    inline fun <reified T> Array<T>.bottomUpMergeSort(comparator: Comparator<T>) {
        with(contentToString()) {
            println(padStart(length + MERGE_STRING_LENGTH))
        }
        val maxDepth = floor(log2((size-1).toDouble())).toInt()
        val memory = arrayOfNulls<T>(size)
        var len = 1
        while (len < size) {
            val depth = maxDepth - log2(len.toDouble()).toInt() // Max depth - current depth
            with("Length = $len") {
                println(padStart(length + depth*2))
            }
            for (low in indices step 2 * len) {
                merge(
                    memory = memory,
                    comparator = comparator,
                    low = low,
                    mid = low + len - 1,
                    high = (low + len + len - 1).coerceAtMost(size - 1),
                    depth = depth,
                )
            }
            len *= 2
        }
        println()
    }

    // Merge two sorted arrays
    fun <T> Array<T>.merge(
        memory: Array<T?>,
        comparator: Comparator<T>,
        low: Int,
        mid: Int,
        high: Int,
        depth: Int,
    ) {
        // Copy items to memory
        for (i in low..high) {
            memory[i] = this[i]
        }

        // Copy sorted items back to the array
        var l = low     // Pointer to left half  [low..mid]
        var r = mid + 1 // Pointer to right half [mid+1 ..high]
        for (i in low..high) {
            if (l > mid) {
                this[i] = memory[r++]!! // Left half is empty
            } else if (r > high) {
                this[i] = memory[l++]!! // Right half is empty
            } else if (comparator.compare(memory[r], memory[l]) < 0) {
                this[i] = memory[r++]!! // Right item is smaller
            } else {
                this[i] = memory[l++]!! // Left item is smaller or equal
            }
        }
        logExercise3(items = this, low = low, mid = mid, high = high, depth = depth)
    }

    private fun <T> logExercise3(items: Array<T>, low: Int, mid: Int, high: Int, depth: Int) {
        val str = "merge(low = $low, mid = $mid, high = $high)"
        print(str.padStart(str.length + depth*2).padEnd(MERGE_STRING_LENGTH))
        println(items.contentToString())
    }

    const val MERGE_STRING_LENGTH = 48
}
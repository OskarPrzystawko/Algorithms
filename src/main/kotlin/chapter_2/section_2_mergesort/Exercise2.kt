package chapter_2.section_2_mergesort


/**
 * 2.2.2
 * Give traces, in the style of the trace given with ALGORITHM 2.4,
 * showing how the keys E A S Y Q U E S T I O N are sorted with top-down mergesort
 *
 *                                                 [E, A, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 0, mid = 0, high = 1)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *     merge(low = 0, mid = 1, high = 2)           [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 3, mid = 3, high = 4)         [A, E, S, Q, Y, U, E, S, T, I, O, N]
 *     merge(low = 3, mid = 4, high = 5)           [A, E, S, Q, U, Y, E, S, T, I, O, N]
 *   merge(low = 0, mid = 2, high = 5)             [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *       merge(low = 6, mid = 6, high = 7)         [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *     merge(low = 6, mid = 7, high = 8)           [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *       merge(low = 9, mid = 9, high = 10)        [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *     merge(low = 9, mid = 10, high = 11)         [A, E, Q, S, U, Y, E, S, T, I, N, O]
 *   merge(low = 6, mid = 8, high = 11)            [A, E, Q, S, U, Y, E, I, N, O, S, T]
 * merge(low = 0, mid = 5, high = 11)              [A, E, E, I, N, O, Q, S, S, T, U, Y]
 */
object Exercise2 {

    inline fun <reified T> Array<T>.topDownMergeSort(comparator: Comparator<T>) {
        with(contentToString()) {
            println(padStart(length + MERGE_STRING_LENGTH))
        }
        mergeSortRecursive(
            comparator = comparator,
            memory = arrayOfNulls(size),
            low = 0,
            high = size - 1,
            depth = 0,
        )
        println()
    }

    fun <T> Array<T>.mergeSortRecursive(
        comparator: Comparator<T>,
        memory: Array<T?>,
        low: Int,
        high: Int,
        depth: Int,
    ) {
        if (low >= high) {
            return
        }
        val mid = (low + high) / 2

        mergeSortRecursive(comparator, memory, low, mid, depth + 1)
        mergeSortRecursive(comparator, memory, mid + 1, high, depth + 1)
        merge(memory, comparator, low, mid, high, depth)
    }

    // Merge two sorted arrays
    private fun <T> Array<T>.merge(
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
        logExercise2(items = this, low = low, mid = mid, high = high, depth = depth)
    }

    private fun <T> logExercise2(items: Array<T>, low: Int, mid: Int, high: Int, depth: Int) {
        val str = "merge(low = $low, mid = $mid, high = $high)"
        print(str.padStart(str.length + depth*2).padEnd(MERGE_STRING_LENGTH))
        println(items.contentToString())
    }

    val MERGE_STRING_LENGTH = 48
}
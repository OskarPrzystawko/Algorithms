package chapter_2.section_2_mergesort

/**
 * 2.2.1
 * Give a trace, in the style of the trace given at the beginning of this section,
 * showing how the keys A E Q S U Y E I N O S T are merged with the abstract in-place merge() method
 *
 * []                                        [A, E, Q, S, U, Y]  [E, I, N, O, S, T]
 * [A]                                          [E, Q, S, U, Y]  [E, I, N, O, S, T]
 * [A, E]                                          [Q, S, U, Y]  [E, I, N, O, S, T]
 * [A, E, E]                                       [Q, S, U, Y]     [I, N, O, S, T]
 * [A, E, E, I]                                    [Q, S, U, Y]        [N, O, S, T]
 * [A, E, E, I, N]                                 [Q, S, U, Y]           [O, S, T]
 * [A, E, E, I, N, O]                              [Q, S, U, Y]              [S, T]
 * [A, E, E, I, N, O, Q]                              [S, U, Y]              [S, T]
 * [A, E, E, I, N, O, Q, S]                              [U, Y]              [S, T]
 * [A, E, E, I, N, O, Q, S, S]                           [U, Y]                 [T]
 * [A, E, E, I, N, O, Q, S, S, T]                        [U, Y]                  []
 * [A, E, E, I, N, O, Q, S, S, T, U]                        [Y]                  []
 * [A, E, E, I, N, O, Q, S, S, T, U, Y]                      []                  []
 *
 */

object Exercise1 {

    // Merge two sorted arrays
    fun <T> Array<T>.merge(
        memory: Array<T?>,
        comparator: Comparator<T>,
        low: Int,
        mid: Int,
        high: Int,
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
            logExercise1(items = this, memory = memory, sortedItems = i, l = l, mid = mid, r = r, high = high)
        }
    }

    private fun <T> logExercise1(items: Array<T>, memory: Array<T?>, sortedItems: Int, l: Int, mid: Int, r: Int, high: Int) {
        print(items.take(sortedItems).toString().padEnd(items.size * 3))
        print(memory.copyOfRange(l, mid+1).contentToString().padStart(memory.size * 3/2))
        println(memory.copyOfRange(r, high+1).contentToString().padStart(memory.size * 3/2))
    }

}
package chapter_2.section_2_mergesort

/**
 * 2.2.10
 * Faster Merge.
 * Implement a version of merge() that copies the second half of input array to memory
 * in decreasing order and then does the merge back to input array.
 * This change allows you to remove the code to test that
 * each of the halves has been exhausted from the inner loop.
 * Note: The resulting sort is not stable.
 */

object Exercise10 {
    // Merge two sorted arrays
    fun <T> Array<T>.fasterMerge(
        memory: Array<T?>,
        comparator: Comparator<T>,
        low: Int,
        mid: Int,
        high: Int,
    ) {
        // Copy items to memory
        for (i in low..mid) {
            memory[i] = this[i]
        }
        for (i in mid+1..high) {
            memory[high + (mid+1) - i] = this[i]
        }

        // Copy sorted items back to the array
        var l = low     // Pointer to left half  [low -> mid]
        var r = high // Pointer to right half [high -> mid+1]

        for (i in low..high) {
            if (comparator.compare(memory[r], memory[l]) < 0) {
                this[i] = memory[r--]!! // Right item is smaller
            } else {
                this[i] = memory[l++]!! // Left item is smaller or equal
            }
        }
    }

}
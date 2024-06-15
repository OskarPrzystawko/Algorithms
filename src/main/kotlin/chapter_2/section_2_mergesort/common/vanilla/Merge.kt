package chapter_2.section_2_mergesort.common.vanilla

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
    }
}
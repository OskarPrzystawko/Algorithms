package chapter_2.section_2_mergesort.common.logs

// Merge two sorted arrays
fun <T> Array<T>.mergeWithLogs(
    memory: Array<T?>,
    comparator: Comparator<T>,
    low: Int,
    mid: Int,
    high: Int,
    depth: Int = 0,
    beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
    whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
    afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _ -> },
) {
    beforeMerge.log(memory, comparator, low, mid, high, depth)
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
        whileMerge.log(memory, comparator, low, mid, high, depth, i, l, r)
    }
    afterMerge.log(memory, comparator, low, mid, high, depth)
}

fun interface MergeLog<T> {
    fun log(
        memory: Array<T?>,
        comparator: Comparator<T>,
        low: Int,
        mid: Int,
        high: Int,
        depth: Int,
    )
}
fun interface MergeLogInnerLoop<T> {
    fun log(
        memory: Array<T?>,
        comparator: Comparator<T>,
        low: Int,
        mid: Int,
        high: Int,
        depth: Int,
        index: Int,
        l: Int,
        r: Int,
    )
}
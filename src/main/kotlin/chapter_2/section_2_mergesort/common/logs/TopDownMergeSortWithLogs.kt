package chapter_2.section_2_mergesort.common.logs


inline fun <reified T> Array<T>.topDownMergeSortWithLogs(
    comparator: Comparator<T>,
    beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
    whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
    afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _ -> },
) {
    mergeSortRecursive(
        comparator = comparator,
        memory = arrayOfNulls(size),
        low = 0,
        high = size - 1,
        depth = 0,
        beforeMerge = beforeMerge,
        whileMerge = whileMerge,
        afterMerge = afterMerge,
    )
}

fun <T> Array<T>.mergeSortRecursive(
    comparator: Comparator<T>,
    memory: Array<T?>,
    low: Int,
    high: Int,
    depth: Int = 0,
    beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
    whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
    afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
) {
    if (low >= high) {
        return
    }
    val mid = (low + high) / 2

    mergeSortRecursive(comparator, memory, low, mid, depth+1, beforeMerge, whileMerge, afterMerge)
    mergeSortRecursive(comparator, memory, mid + 1, high, depth+1, beforeMerge, whileMerge, afterMerge)
    mergeWithLogs(memory, comparator, low, mid, high, depth, beforeMerge, whileMerge, afterMerge)
}


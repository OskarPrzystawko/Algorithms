package chapter_2.section_2_mergesort.common.test

inline fun <reified T> Array<T>.bottomUpMergeSortTest(
    comparator: Comparator<T>,
    onLengthChange: (length: Int) -> Unit = {},
    beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
    whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
    afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _ -> },
): Stats {
    var stats = Stats(0, 0)
    val memory = arrayOfNulls<T>(size)
    var len = 1
    while (len < size) {
        onLengthChange(len)
        var low = 0
        while (low < size - len) {
            stats += mergeTest(
                memory = memory,
                comparator = comparator,
                low = low,
                mid = low + len - 1,
                high = (low + len + len - 1).coerceAtMost(size - 1),
                beforeMerge = beforeMerge,
                whileMerge = whileMerge,
                afterMerge = afterMerge,
            )
            low += 2*len
        }
        len *= 2
    }
    return stats
}
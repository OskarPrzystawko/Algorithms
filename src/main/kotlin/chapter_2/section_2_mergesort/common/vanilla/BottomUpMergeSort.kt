package chapter_2.section_2_mergesort.common.vanilla

inline fun <reified T> Array<T>.bottomUpMergeSort(comparator: Comparator<T>) {
    val memory = arrayOfNulls<T>(size)
    var len = 1
    while (len < size) {
        var low = 0
        while (low < size - len) {
            merge(
                memory = memory,
                comparator = comparator,
                low = low,
                mid = low + len - 1,
                high = (low + len + len - 1).coerceAtMost(size - 1),
            )
            low += 2*len
        }
        len *= 2
    }
}
package chapter_2.section_2_mergesort.common.arrayaccess

inline fun <reified T> Array<T>.bottomUpMergeSortArrayAccess(comparator: Comparator<T>): Int {
    var arrayAccesses = 0
    val memory = arrayOfNulls<T>(size)
    var len = 1
    while (len < size) {
        var low = 0
        while (low < size - len) {
            arrayAccesses += mergeArrayAccess(
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

    return arrayAccesses
}
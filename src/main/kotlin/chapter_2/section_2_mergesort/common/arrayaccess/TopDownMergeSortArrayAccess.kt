package chapter_2.section_2_mergesort.common.arrayaccess


inline fun <reified T> Array<T>.topDownMergeSortArrayAccess(comparator: Comparator<T>): Int {
    return mergeSortRecursiveArrayAccess(
        comparator = comparator,
        memory = arrayOfNulls(size),
        low = 0,
        high = size - 1,
    )
}

fun <T> Array<T>.mergeSortRecursiveArrayAccess(
    comparator: Comparator<T>,
    memory: Array<T?>,
    low: Int,
    high: Int,
): Int {
    if (low >= high) {
        return 0
    }
    val mid = (low + high) / 2

    return mergeSortRecursiveArrayAccess(comparator, memory, low, mid) +
            mergeSortRecursiveArrayAccess(comparator, memory, mid + 1, high) +
            mergeArrayAccess(memory, comparator, low, mid, high)
}


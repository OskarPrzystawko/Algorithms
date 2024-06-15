package chapter_2.section_2_mergesort.common.vanilla


inline fun <reified T> Array<T>.topDownMergeSort(comparator: Comparator<T>) {
    mergeSortRecursive(
        comparator = comparator,
        memory = arrayOfNulls(size),
        low = 0,
        high = size - 1,
    )
}

fun <T> Array<T>.mergeSortRecursive(
    comparator: Comparator<T>,
    memory: Array<T?>,
    low: Int,
    high: Int,
) {
    if (low >= high) {
        return
    }
    val mid = (low + high) / 2

    mergeSortRecursive(comparator, memory, low, mid)
    mergeSortRecursive(comparator, memory, mid + 1, high)
    merge(memory, comparator, low, mid, high)
}


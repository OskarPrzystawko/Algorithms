package main.chapter_2.section_1

open class SortBase {

    open fun <T: Comparable<T>> less(a: T, b: T) = a < b

    fun <T: Comparable<T>> exchange(array: Array<T>, aIndex: Int, bIndex: Int) {
        val temp = array[aIndex]
        array[aIndex] = array[bIndex]
        array[bIndex] = temp
    }

}

fun <T: Comparable<T>> Array<T>.isSorted(): Boolean {
    for (i in 0 until size - 1) {
        if (this[i] > this[i + 1]) {
            return false
        }
    }
    return true
}
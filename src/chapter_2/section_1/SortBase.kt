package chapter_2.section_1

open class SortBase {

    fun less(a: Comparable<Any>, b: Comparable<Any>) = a < b

    fun exchange(array: Array<Comparable<Any>>, aIndex: Int, bIndex: Int) {
        val temp = array[aIndex]
        array[aIndex] = array[bIndex]
        array[bIndex] = temp
    }

}
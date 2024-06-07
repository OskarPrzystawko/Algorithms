package main.chapter_2.section_1

object PrecalculatedSequenceShellSort: SortBase() {

    private val H_SEQUENCE = intArrayOf(
            1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484,
            7174453, 21523360, 64570081, 193710244, 581130733
    )
    private val MAX_INPUT_SIZE = 3 * H_SEQUENCE[H_SEQUENCE.size - 1] + 1

    fun <T : Comparable<T>> sort(items: Array<T>) {
        val size = items.size
        if (size <= 1) return
        require(size <= MAX_INPUT_SIZE) { "Too big input array. Max array size is: $MAX_INPUT_SIZE" }

        for (t in getMaxHIndex(size) downTo 0) {
            val h = H_SEQUENCE[t]
            for (i in h until size) {
                var j = i
                while (j >= h && less(items[j], items[j - h])) {
                    exchange(items, j, j - h)
                    j -= h
                }
            }
        }
    }

    private fun getMaxHIndex(arraySize: Int) = H_SEQUENCE.findLast {
        it < arraySize - 1
    } ?: 0

}
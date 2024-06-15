package chapter_2.section_2_mergesort.common.test

data class Stats(
    var arrayAccesses: Int,
    var comparisons: Int,
) {

    operator fun plus(stats: Stats) = Stats(
        arrayAccesses = arrayAccesses + stats.arrayAccesses,
        comparisons = comparisons + stats.comparisons
    )

    companion object {
        val EMPTY = Stats(0,0)
    }

}
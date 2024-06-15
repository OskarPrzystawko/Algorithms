package chapter_2.section_2_mergesort

import chapter_2.section_2_mergesort.common.test.MergeLog
import chapter_2.section_2_mergesort.common.test.MergeLogInnerLoop
import chapter_2.section_2_mergesort.common.test.Stats
import chapter_2.section_2_mergesort.common.test.mergeTest

/**
 * 2.2.8
 * Suppose that top-down mergesort is modified to skip the call on merge()
 * whenever a[mid] <= a[mid+1]. Prove that the number of compares used
 * to mergesort a sorted array is linear.
 *
 * With this modification if the input is sorted array
 * then merge() will be always skipped
 * so instead of merge(), single compare will be only used to check if mid items are sorted
 * there would be at most N merge() (N/2 + N/4 + N/8 +... -> 1)
 * so the number of compares is at most N
 * so it is linear
 *
 * items: 8          | comparisons: 7        | comparisons/items: 1.0
 * items: 16         | comparisons: 15       | comparisons/items: 1.0
 * items: 32         | comparisons: 31       | comparisons/items: 1.0
 * items: 64         | comparisons: 63       | comparisons/items: 1.0
 * items: 128        | comparisons: 127      | comparisons/items: 1.0
 * items: 256        | comparisons: 255      | comparisons/items: 1.0
 * items: 512        | comparisons: 511      | comparisons/items: 1.0
 * items: 1024       | comparisons: 1023     | comparisons/items: 1.0
 * items: 2048       | comparisons: 2047     | comparisons/items: 1.0
 * items: 4096       | comparisons: 4095     | comparisons/items: 1.0
 * items: 8192       | comparisons: 8191     | comparisons/items: 1.0
 * items: 16384      | comparisons: 16383    | comparisons/items: 1.0
 * items: 32768      | comparisons: 32767    | comparisons/items: 1.0
 * items: 65536      | comparisons: 65535    | comparisons/items: 1.0
 * items: 131072     | comparisons: 131071   | comparisons/items: 1.0
 * items: 262144     | comparisons: 262143   | comparisons/items: 1.0
 * items: 524288     | comparisons: 524287   | comparisons/items: 1.0
 * items: 1048576    | comparisons: 1048575  | comparisons/items: 1.0
 *
 */
object Exercise8 {
    inline fun <reified T> topDownMergeSortTest(
        items: Array<T>,
        comparator: Comparator<T>,
        beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
        whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
        afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _ -> },
    ): Stats {
        return mergeSortRecursive(
            items = items,
            comparator = comparator,
            memory = arrayOfNulls(items.size),
            low = 0,
            high = items.size - 1,
            depth = 0,
            beforeMerge = beforeMerge,
            whileMerge = whileMerge,
            afterMerge = afterMerge,
        )
    }

    fun <T> mergeSortRecursive(
        items: Array<T>,
        comparator: Comparator<T>,
        memory: Array<T?>,
        low: Int,
        high: Int,
        depth: Int = 0,
        beforeMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
        whileMerge: MergeLogInnerLoop<T> = MergeLogInnerLoop { _, _, _, _, _, _, _, _, _ -> },
        afterMerge: MergeLog<T> = MergeLog { _, _, _, _, _, _-> },
    ): Stats {
        if (low >= high) {
            return Stats.EMPTY
        }
        var stats = Stats.EMPTY
        val mid = (low + high) / 2

        stats += mergeSortRecursive(items, comparator, memory, low, mid, depth+1, beforeMerge, whileMerge, afterMerge)
        stats += mergeSortRecursive(items, comparator, memory, mid + 1, high, depth+1, beforeMerge, whileMerge, afterMerge)
        if (comparator.compare(items[mid], items[mid+1]) > 0) {
            stats += items.mergeTest(memory, comparator, low, mid, high, depth, beforeMerge, whileMerge, afterMerge)
        }
        stats.comparisons++
        return stats
    }

}
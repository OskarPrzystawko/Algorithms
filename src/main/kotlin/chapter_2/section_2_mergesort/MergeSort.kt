package chapter_2.section_2_mergesort

import kotlin.Comparator

// Merge two sorted arrays
fun <T> merge(
    itemsToMerge: Array<T>,
    memory: Array<T?>,
    comparator: Comparator<T>,
    low: Int,
    mid: Int,
    high: Int,
) {
    // Copy items to memory
    for (i in low.. high) {
        memory[i] = itemsToMerge[i]
    }

    // Copy sorted items back to the array
    var l = low     // Pointer to left half  [low..mid]
    var r = mid + 1 // Pointer to right half [mid+1 ..high]
    for (i in low..high) {
        if (l > mid) {
            itemsToMerge[i] = memory[r++]!! // Left half is empty
        } else if (r > high) {
            itemsToMerge[i] = memory[l++]!! // Right half is empty
        } else if (comparator.compare(memory[r], memory[l]) < 0) {
            itemsToMerge[i] = memory[r++]!! // Right item is smaller
        } else {
            itemsToMerge[i] = memory[l++]!! // Left item is smaller or equal
        }
    }
}

// Used for exercise 1
private fun <T> log(items: Array<T>, memory: Array<T?>, sortedItems: Int, l: Int, mid: Int, r: Int, high: Int) {
    print(items.take(sortedItems).toString().padEnd(items.size * 3))
    print(memory.copyOfRange(l, mid+1).contentToString().padStart(memory.size * 3/2))
    println(memory.copyOfRange(r, high+1).contentToString().padStart(memory.size * 3/2))
}
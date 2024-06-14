package chapter_2.section_2_mergesort

/**
 * 2.2.4
 * Does the abstract in-place merge produce proper output if and only if the two
 * input subarrays are in sorted order? Prove your answer, or provide a counterexample.
 *
 * Yes, it produces sorted array if and only if input subarrays are sorted
 * 1. If it was producing sorted array from 2 unsorted arrays then
 *    it would be comparison-based linear-time sorting algorithm which is not possible
 * 2. merge() goes through the array from left to right without going back
 *    so if smallest element would be at the end of one of subarrays
 *    then merge() cannot go back to the beginning of the array to put it in proper place
 */
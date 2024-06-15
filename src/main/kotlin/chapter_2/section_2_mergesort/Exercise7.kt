package chapter_2.section_2_mergesort

/**
 * 2.2.7
 * Show that the number of compares used by mergesort is monotonically increasing
 * C(n+1)) > C(n)) for all n > 0
 *
 * Mathematically in worst case:
 * C(n) = lg(n) * n
 * C(n+1) = lg(n+1) * (n+1)
 *
 * C(n+1) > C(n)
 * lg(n+1) * (n+1) > lg(n) * n
 *
 * also
 * lg(n) - is monotonically increasing function
 * n - linear function is monotonically increasing function
 * so
 * C(n) - function created from multiplication of monotonically increasing functions
 * for n > 0 will be monotonically increasing
 *
 * ---------
 *
 * BUT in practise - there might be some cases where C(n+1) is equal or slightly smaller than C(n)
 * Check file Exercise7Test
 *
 */
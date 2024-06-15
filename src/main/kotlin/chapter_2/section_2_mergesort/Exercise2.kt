package chapter_2.section_2_mergesort

/**
 * 2.2.2
 * Give traces, in the style of the trace given with ALGORITHM 2.4,
 * showing how the keys E A S Y Q U E S T I O N are sorted with top-down mergesort
 *
 *                                                 [E, A, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 0, mid = 0, high = 1)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *     merge(low = 0, mid = 1, high = 2)           [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 3, mid = 3, high = 4)         [A, E, S, Q, Y, U, E, S, T, I, O, N]
 *     merge(low = 3, mid = 4, high = 5)           [A, E, S, Q, U, Y, E, S, T, I, O, N]
 *   merge(low = 0, mid = 2, high = 5)             [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *       merge(low = 6, mid = 6, high = 7)         [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *     merge(low = 6, mid = 7, high = 8)           [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *       merge(low = 9, mid = 9, high = 10)        [A, E, Q, S, U, Y, E, S, T, I, O, N]
 *     merge(low = 9, mid = 10, high = 11)         [A, E, Q, S, U, Y, E, S, T, I, N, O]
 *   merge(low = 6, mid = 8, high = 11)            [A, E, Q, S, U, Y, E, I, N, O, S, T]
 * merge(low = 0, mid = 5, high = 11)              [A, E, E, I, N, O, Q, S, S, T, U, Y]
 *
 */
package chapter_2.section_2_mergesort

/**
 * 2.2.3
 * Give traces, in the style of the trace given with ALGORITHM 2.4,
 * showing how the keys E A S Y Q U E S T I O N are sorted with bottom-up mergesort
 *
 *                                                 [E, A, S, Y, Q, U, E, S, T, I, O, N]
 *       Length = 1
 *       merge(low = 0, mid = 0, high = 1)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 2, mid = 2, high = 3)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 4, mid = 4, high = 5)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 6, mid = 6, high = 7)         [A, E, S, Y, Q, U, E, S, T, I, O, N]
 *       merge(low = 8, mid = 8, high = 9)         [A, E, S, Y, Q, U, E, S, I, T, O, N]
 *       merge(low = 10, mid = 10, high = 11)      [A, E, S, Y, Q, U, E, S, I, T, N, O]
 *     Length = 2
 *     merge(low = 0, mid = 1, high = 3)           [A, E, S, Y, Q, U, E, S, I, T, N, O]
 *     merge(low = 4, mid = 5, high = 7)           [A, E, S, Y, E, Q, S, U, I, T, N, O]
 *     merge(low = 8, mid = 9, high = 11)          [A, E, S, Y, E, Q, S, U, I, N, O, T]
 *   Length = 4
 *   merge(low = 0, mid = 3, high = 7)             [A, E, E, Q, S, S, U, Y, I, N, O, T]
 *   merge(low = 8, mid = 11, high = 11)           [A, E, E, Q, S, S, U, Y, I, N, O, T]
 * Length = 8
 * merge(low = 0, mid = 7, high = 11)              [A, E, E, I, N, O, Q, S, S, T, U, Y]
 */
package chapter_2.section_2_mergesort

/**
 * 2.2.1
 * Give a trace, in the style of the trace given at the beginning of this section,
 * showing how the keys A E Q S U Y E I N O S T are merged with the abstract in-place merge() method
 *
 * []                                        [A, E, Q, S, U, Y]  [E, I, N, O, S, T]
 * [A]                                          [E, Q, S, U, Y]  [E, I, N, O, S, T]
 * [A, E]                                          [Q, S, U, Y]  [E, I, N, O, S, T]
 * [A, E, E]                                       [Q, S, U, Y]     [I, N, O, S, T]
 * [A, E, E, I]                                    [Q, S, U, Y]        [N, O, S, T]
 * [A, E, E, I, N]                                 [Q, S, U, Y]           [O, S, T]
 * [A, E, E, I, N, O]                              [Q, S, U, Y]              [S, T]
 * [A, E, E, I, N, O, Q]                              [S, U, Y]              [S, T]
 * [A, E, E, I, N, O, Q, S]                              [U, Y]              [S, T]
 * [A, E, E, I, N, O, Q, S, S]                           [U, Y]                 [T]
 * [A, E, E, I, N, O, Q, S, S, T]                        [U, Y]                  []
 * [A, E, E, I, N, O, Q, S, S, T, U]                        [Y]                  []
 * [A, E, E, I, N, O, Q, S, S, T, U, Y]                      []                  []
 *
 */
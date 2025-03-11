package com.sezeme.section02.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class E_BruteForceTest {

    static String input1, input2, input3;
    static Integer output1, output2, output3;

    @BeforeAll
    static void setUp() {
        /* "1 2 3" → 순열의 개수: 3! = 6 */
        input1 = "1 2 3";
        output1 = 6;

        /* "1 2 3 4" → 순열의 개수: 4! = 24 */
        input2 = "1 2 3 4";
        output2 = 24;

        /* "1 2" → 순열의 개수: 2! = 2 */
        input3 = "1 2";
        output3 = 2;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.arguments(input1, output1),
                Arguments.arguments(input2, output2),
                Arguments.arguments(input3, output3)
        );
    }

    @DisplayName("Permutation (Backtracking)")
    @ParameterizedTest
    @MethodSource("provideSource")
    void permutationTest(String input, Integer output) {
        Integer result = E_BruteForce.solution(input);
        Assertions.assertEquals(output, result);
    }
}

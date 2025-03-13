package com.sezeme.section04.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class E_TriangleMaxSumTest {
    private static String input1;
    private static Integer output1;

    @BeforeAll
    static void set() {

        input1 = "5\n" +
                "7\n" +
                "3 8\n" +
                "8 1 0\n" +
                "2 7 4 4\n" +
                "4 5 2 6 5";
        output1 = 30;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }

    @DisplayName("TriangleMaxSum")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    void TriangleMaxSumTest(String input, Integer output) throws Exception {
        Integer result = E_TriangleMaxSum.solution(input);
        Assertions.assertEquals(output, result);
    }
}
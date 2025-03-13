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

/* 백준 12865 평범한 배낭 */
class G_KnapsackTest {

    private static String input1;
    private static Integer output1;

    @BeforeAll
    static void set() {

        input1 = "4 7\n" +
                "6 13\n" +
                "4 8\n" +
                "3 6\n" +
                "5 12\n";
        output1 = 14;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }
    @DisplayName("Knapsack")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    void knapsackTest(String input, Integer output) throws Exception {
        Integer result = G_Knapsack.solution(input);
        Assertions.assertEquals(output, result);
    }
}
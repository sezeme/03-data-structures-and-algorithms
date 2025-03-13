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

class F_StairClimbingTest {
    private static String input1;
    private static Integer output1;

    @BeforeAll
    public static void set() {

        input1 = "6\n" +
                "10\n" +
                "20\n" +
                "15\n" +
                "25\n" +
                "10\n" +
                "20";
        output1 = 75;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }
    @DisplayName("StairClimbing")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    void stairClimbingTest(String input, Integer output) throws Exception {
        Integer result = F_StairClimbing.solution(input);
        Assertions.assertEquals(output, result);
    }
}
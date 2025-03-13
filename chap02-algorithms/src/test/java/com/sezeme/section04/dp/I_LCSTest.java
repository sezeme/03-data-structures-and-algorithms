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

class I_LCSTest {
    private static String input1;
    private static Integer output1;

    @BeforeAll
    static void set() {

        input1 = "ACAYKP\n" +
                "CAPCAK";
        output1 = 4;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }

    @DisplayName("LCS")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void LCSTest(String input, Integer output) throws Exception {
        Integer result = I_LCS.solution(input);
        Assertions.assertEquals(output, result);
    }
}
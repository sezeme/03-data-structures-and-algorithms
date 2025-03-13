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

class C_TilingTest {
    private static Integer input1, input2;
    private static Integer output1, output2;

    @BeforeAll
    static void setUp() {

        input1 = 2;
        output1 = 2;

        input2 = 9;
        output2 = 55;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("Tiling")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    void tilingTest(Integer input, Integer output) throws Exception {
        Integer result = C_Tiling.solution(input);
        Assertions.assertEquals(output, result);
    }
}
package com.sezeme.section07.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/* 보석 도둑 - 백준 (1202) */
class Practice2Test {

    Practice2 practice2;
    static String input1, input2;
    static int output1, output2;

    @BeforeAll
    public static void set() {

        input1 = "2 1\n" +
                "5 10\n" +
                "100 100\n" +
                "11";

        input2 = "3 2\n" +
                "1 65\n" +
                "5 23\n" +
                "2 99\n" +
                "10\n" +
                "2";

        output1 = 10;
        output2 = 164;
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @BeforeEach
    void setUp() {
        practice2 = new Practice2();
    }


    @DisplayName("보석 도둑 테스트")
    @ParameterizedTest
    @MethodSource("provideSource")
    void testSolution(String input, long output) throws Exception {
        long result = practice2.solution(input);
        Assertions.assertEquals(output, result);
    }
}

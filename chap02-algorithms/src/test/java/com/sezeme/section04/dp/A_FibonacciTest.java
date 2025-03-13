package com.sezeme.section04.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class A_FibonacciTest {

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(10, 55),
                arguments(40, 102334155)
        );
    }

    @DisplayName("기본 재귀 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest1(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumber(input);
        Assertions.assertEquals(output, result);
    }

    @DisplayName("DP-Top Down 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest2(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumberDP(input);
        Assertions.assertEquals(output, result);
    }

    @DisplayName("DP-Bottom Up 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest3(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumberIter(input);
        Assertions.assertEquals(output, result);
    }
}
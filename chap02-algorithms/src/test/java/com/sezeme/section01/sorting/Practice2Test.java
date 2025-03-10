package com.sezeme.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class Practice2Test {
    static int[] act, exp;

    @BeforeAll
    static void setUp()  {
        act = new int[]{
                42, 32, 24, 60, 15, 5, 90, 45, 77, 68,
                50, 3, 99, 10, 22, 85, 33, 18, 70, 11,
                88, 54, 29, 63, 37, 12, 76, 2, 41, 31,
                67, 58, 80, 14, 95, 6, 49, 21, 39, 27
        };
        exp = new int[]{
                2, 3, 5, 6, 10, 11, 12, 14, 15, 18,
                21, 22, 24, 27, 29, 31, 32, 33, 37, 39,
                41, 42, 45, 49, 50, 54, 58, 60, 63, 67,
                68, 70, 76, 77, 80, 85, 88, 90, 95, 99
        };
    }

    static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(act, exp)
        );
    }

    @DisplayName("timsort 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testTimSort(int[] actual, int[] expected) {
        Practice2.timSort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}
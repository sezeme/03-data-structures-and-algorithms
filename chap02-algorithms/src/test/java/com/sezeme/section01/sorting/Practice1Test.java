package com.sezeme.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Practice1Test {
    static int[] act1, act2, exp1, exp2;

    @BeforeAll
    static void setup() {
        act1 = new int[]{1, 2, 3, 4, 5};
        exp1 = new int[]{1, 2, 3, 4, 5};
        act2 = new int[]{10, 20, 30, 40, 50};
        exp2 = new int[]{10, 20, 30, 40, 50};
    }

    static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(act1, exp1),
                Arguments.of(act2, exp2)
        );
    }

    @DisplayName("최적화 된 버블 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testBubbleSort(int[] actual, int[] expected) {
        Practice1.bubbleSort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
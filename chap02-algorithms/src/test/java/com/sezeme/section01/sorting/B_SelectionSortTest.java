package com.sezeme.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class B_SelectionSortTest {
    static int[] act1, act2, exp1, exp2;

    @BeforeAll
    static void setup() {
        act1 = new int[]{34, 23, 5, 24, 1, 9, 12};
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};
        act2 = new int[]{40, 47, 38, 8, 33, 35};
        exp2 = new int[]{8, 33, 35, 38, 40, 47};
    }

    static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(act1, exp1),
                Arguments.of(act2, exp2)
        );
    }

    @DisplayName("선택 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testSelectionSort(int[] actual, int[] expected) {
        B_SelectionSort.solution(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
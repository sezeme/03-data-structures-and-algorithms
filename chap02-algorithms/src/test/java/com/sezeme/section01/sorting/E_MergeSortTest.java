package com.sezeme.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class E_MergeSortTest {

    static int[] act, exp;

    @BeforeAll
    static void setUp() {
        act = new int[] {42, 32, 24, 60, 15, 5, 90, 45};
        exp = new int[] {5, 15, 24, 32, 42, 45, 60, 90};
    }

    static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(act, exp)
        );
    }

    @DisplayName("병합 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testMergeSort(int[] actual, int[] expected) {
        E_MergeSort.solution(actual);
        Assertions.assertArrayEquals(expected, actual);
    }




}
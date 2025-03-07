//package com.sezeme.section05.deque;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.stream.Stream;
//
///* AC - 백준 (5430) */
//class Practice2Test {
//
//    Practice2 practice2;
//
//    @BeforeEach
//    void setUp() {
//        practice2 = new Practice2();
//    }
//
//    static Stream<Arguments> provideTestCases() {
//        return Stream.of(
//                Arguments.arguments("RDD", new Integer[]{1,2,3,4}, "[2,1]"),
//                Arguments.arguments("DD", new Integer[]{42}, "error"),
//                Arguments.arguments("RRD", new Integer[]{1,1,2,3,5,8}, "[1,2,3,5,8]"),
//                Arguments.arguments("D", new Integer[]{}, "error")
//        );
//    }
//
//    @DisplayName("AC 테스트")
//    @ParameterizedTest
//    @MethodSource("provideTestCases")
//    void testSolution(String command, Integer[] array, String expected) {
//        String result = practice2.solution(command, array);
//        Assertions.assertEquals(expected, result);
//    }
//
//}
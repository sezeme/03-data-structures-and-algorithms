//package com.sezeme.section04.queue;
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
///* 요세푸스 문제 - 백준 (1158) */
//class Practice1Test {
//
//    Practice1 practice1;
//
//    @BeforeEach
//    void setUp() {
//        practice1 = new Practice1();
//    }
//
//    static Stream<Arguments> provideTestCases() {
//        return Stream.of(
//                Arguments.arguments(7, 3, "<3, 6, 2, 7, 5, 1, 4>"),
//                Arguments.arguments(5, 2, "<2, 4, 1, 5, 3>")
//        );
//    }
//
//    @DisplayName("요세푸스 테스트")
//    @ParameterizedTest
//    @MethodSource("provideTestCases")
//    void testSolution(int n, int k, String expected) {
//        String result = practice1.solution(n, k);
//        Assertions.assertEquals(expected, result);
//    }
//
//}
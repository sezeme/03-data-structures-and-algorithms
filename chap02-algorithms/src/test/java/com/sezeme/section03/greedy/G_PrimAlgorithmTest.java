package com.sezeme.section03.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/* 백준 - 최소 스패닝 트리 (1197)
MST, Minimum Spanning Tree
주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
*/
class G_PrimAlgorithmTest {
    static String input1, input2;
    static Long output1, output2;

    @BeforeAll
    public static void set() {

        input1 = "3 3\n" +
                "1 2 1\n" +
                "2 3 2\n" +
                "1 3 3";
        output1 = 3L;


        input2 = "5 7\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "2 3 4\n" +
                "2 4 5\n" +
                "3 4 6\n" +
                "3 5 7\n" +
                "4 5 8";
        output2 = 17L;

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("PrimAlgorithm")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void primAlgorithmTest(String input, Long output) throws IOException {
        Long result = G_PrimAlgorithm.solution(input);
        Assertions.assertEquals(output, result);
    }
}
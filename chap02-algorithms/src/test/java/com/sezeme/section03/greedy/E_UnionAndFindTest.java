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

/* 친구 관계
학생들은 각각 고유한 번호로 식별되며, 주어진 친구 관계 쌍에 따라 학생들이 같은 그룹(친구 관계의 집합)에 속하는지 확인
첫 번째 줄에 학생 수 N (1 <= N <= 1,000)과 친구 관계 쌍의 수 M (1 <= M <= 3,000)
다음 M개의 줄에는 친구 관계를 나타내는 두 개의 정수
마지막 줄에는 두 학생 x와 y
두 학생 x와 y가 같은 그룹에 속하는지 확인하여 YES or NO 출력
*/
class E_UnionAndFindTest {
    static String input1, input2;
    static String output1, output2;

    @BeforeAll
    public static void set() {

        input1 = "9 7\n" +
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 8";
        output1 = "NO";

        input2 = "9 7\n" +
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 5";
        output2 = "YES";
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("Union & Find")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void unionAndFindTest(String input, String output) throws IOException {
        String result = E_UnionAndFind.solution(input);
        Assertions.assertEquals(output, result);
    }
}
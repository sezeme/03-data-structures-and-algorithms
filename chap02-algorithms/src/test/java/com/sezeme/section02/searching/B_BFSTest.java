package com.sezeme.section02.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class B_BFSTest {

    static String input1, input2, input3;
    static Integer output1,output2, output3;

    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = "10 8 17\n" +
                "0 0\n" +
                "1 0\n" +
                "1 1\n" +
                "4 2\n" +
                "4 3\n" +
                "4 5\n" +
                "2 4\n" +
                "3 4\n" +
                "7 4\n" +
                "8 4\n" +
                "9 4\n" +
                "7 5\n" +
                "8 5\n" +
                "9 5\n" +
                "7 6\n" +
                "8 6\n" +
                "9 6";
        output1 = 5;

        input2 = "10 10 1\n" +
                "5 5\n";
        output2 = 1;

        input3 = "5 3 6\n" +
                "0 2\n" +
                "1 2\n" +
                "2 2\n" +
                "3 2\n" +
                "4 2\n" +
                "4 0";
        output3 = 2;

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)
        );
    }
    @DisplayName("bfs")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void bfsTest(String input, Integer output) throws Exception {
        Integer result = B_BFS.solution(input);
//        Integer result = B_BFS_2.solution(input);
        Assertions.assertEquals(output, result);
    }
}

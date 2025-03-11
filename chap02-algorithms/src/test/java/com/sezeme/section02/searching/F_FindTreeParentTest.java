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

public class F_FindTreeParentTest {

    private static String input1, input2;
    private static String output1, output2;

    @BeforeAll
    public static void set() {

        input1 = "7\n" +
                "1 6\n" +
                "6 3\n" +
                "3 5\n" +
                "4 1\n" +
                "2 4\n" +
                "4 7";
        output1 = "4 6 1 3 1 4 ";

        /* 예시2 */
        input2 = "12\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "3 5\n" +
                "3 6\n" +
                "4 7\n" +
                "4 8\n" +
                "5 9\n" +
                "5 10\n" +
                "6 11\n" +
                "6 12";
        output2 = "1 1 2 3 3 4 4 5 5 6 6 ";

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("tree1")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void treeTest(String input, String output) throws Exception {
        String result = F_FindTreeParent.solution(input);
        Assertions.assertEquals(output, result);
    }
}

package com.sezeme.section03.greedy;

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

class C_MeetingRoomSchedulerTest {
    private static String input1, input2, input3;
    private static Integer output1, output2, output3;

    @BeforeAll
    public static void set() {

        input1 = "11\n" +
                "1 4\n" +
                "3 5\n" +
                "0 6\n" +
                "5 7\n" +
                "3 8\n" +
                "5 9\n" +
                "6 10\n" +
                "8 11\n" +
                "8 12\n" +
                "2 13\n" +
                "12 14";
        output1 = 4;

        input2 = "5\n" +
                "1 4\n" +
                "2 3\n" +
                "3 5\n" +
                "4 6\n" +
                "5 7\n";
        output2 = 3;

        input3 = "3\n" +
                "3 3\n" +
                "1 3\n" +
                "2 3\n";
        output3 = 2;


    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)

        );
    }

    @DisplayName("MeetingRoomScheduler")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void meetingRoomSchedulerTest(String input, Integer output) throws Exception {
        Integer result = C_MeetingRoomScheduler.solution(input);
        Assertions.assertEquals(output, result);
    }
}
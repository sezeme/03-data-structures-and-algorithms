package com.sezeme.section05.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Practice2 {
    public String solution(String command, Integer[] array) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(array));
        boolean isAscending = true;
        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isAscending = !isAscending;
            } else {
                if (deque.isEmpty()) return "error";
                if (isAscending) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(isAscending ? deque.removeFirst() : deque.removeLast());
            if(!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");


        return sb.toString();
    }
}

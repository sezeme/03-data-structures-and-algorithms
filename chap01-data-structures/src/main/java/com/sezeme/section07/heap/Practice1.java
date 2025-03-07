package com.sezeme.section07.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    public String solution(Integer[] array) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
            if(absCompare == 0) {
                return Integer.compare(a, b);
            }
            return absCompare;
        });

        StringBuilder sb = new StringBuilder();

        Arrays.stream(array).skip(1).forEach(i -> {
            if(i == 0) {
                sb.append(pq.isEmpty() ? "0" : pq.poll().toString()).append(" ");
            }
            else pq.offer(i);
        });

        return sb.toString().trim();
    }
}

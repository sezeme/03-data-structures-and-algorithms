package com.sezeme.section04.queue;

import java.io.IOException;
import java.util.*;

public class Practice1 {
    public String solution(int n, int k) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringJoiner sj = new StringJoiner(", ", "<",">");
        while (!q.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                q.offer(q.poll());
            }
            sj.add(q.poll().toString());
        }

        return sj.toString();
    }

}

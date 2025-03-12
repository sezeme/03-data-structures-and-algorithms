package com.sezeme.section05.deque;

import java.util.*;

public class Practice1 {
    static class Balloon {
        int order;
        int noteValue;

        public Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }
    public String solution(Integer[] notes) {
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> balloons = new ArrayDeque<>();
        for(int i = 0; i< notes.length ; i++){
            balloons.add(new Balloon(i+1, notes[i]));
        }

        // 무조건 첫 번째 풍선이 먼저 제거
        Balloon current = balloons.removeFirst();
        sb.append(current.order);

        while(!balloons.isEmpty()) {
            int moveValue = current.noteValue;

            if(moveValue > 0) {
                for(int i = 1; i< moveValue; i++){
                    balloons.addLast(balloons.removeFirst());
                }
                current = balloons.removeFirst();
            } else {
                for(int i = 1; i < -moveValue; i++){
                    balloons.addFirst(balloons.removeLast());
                }
                current = balloons.removeLast();
            }

            sb.append(" ").append(current.order);
        }

        return sb.toString();
    }
}

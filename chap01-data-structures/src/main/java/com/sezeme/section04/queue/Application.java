package com.sezeme.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

/* Java Collection Framework에는 Queue 인터페이스와 이를 구현한 여러 클래스가 있다.
 * 여기서는 LinkedList를 사용하여 구현하였다.
 * */
public class Application {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 요소 추가
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // 요소 조회
        System.out.println(queue.peek());

        // 요소 제거
        System.out.println(queue.poll());

        // 큐 비어있는지 확인
        System.out.println(queue.isEmpty());
    }
}

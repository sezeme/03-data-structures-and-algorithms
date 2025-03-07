package com.sezeme.section07.heap;

import java.util.PriorityQueue;

/* Java Collection Framework 에서 heap을 직접 지원하는 클래스는 없지만
* PriorityQueue 클래스를 이용하여 heap을 구현할 수 있다.
* */
public class Application {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //요소 추가
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(8);

        //최솟값 조회
        System.out.println(minHeap.peek());

        //최솟값 제거
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //요소 추가
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(8);

        //최댓값 조회
        System.out.println(maxHeap.peek());

        //최댓값 제거
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());
    }
}

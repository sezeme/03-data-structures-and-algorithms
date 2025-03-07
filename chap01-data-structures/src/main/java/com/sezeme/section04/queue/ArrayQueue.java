package com.sezeme.section04.queue;

/* 배열 기반 큐 예제 (원형 큐) */
public class ArrayQueue<T> {
    private T[] queue;
    private int front, rear, size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    // 데이터 x를 큐의 맨 뒤에 추가 (offer)
    public void offer(T data) {
        if (size == queue.length) resize();
        queue[rear] = data;
        /* 데이터를 큐에 추가한 후, rear(마지막 데이터가 들어가는 위치)를 다음 인덱스로 이동
         * 만약 rear가 배열의 마지막 인덱스라면(queue.length - 1), rear + 1은 배열의 길이와 같아지지만,
         * % queue.length 연산을 적용하면 0이 되어 배열의 처음 위치로 돌아감
         * 이 방식으로 배열의 경계를 넘어가지 않고, 큐의 빈 공간을 효율적으로 재사용 */
        rear = (rear + 1) % queue.length;
        size++;
    }

    // 큐의 맨 앞 데이터를 제거하고 반환 (poll)
    public T poll() {
        if (isEmpty()) return null;
        T data = queue[front];
        queue[front] = null; // 메모리 해제를 위해 null로 설정
        /* 데이터를 큐에서 제거한 후, front(가장 먼저 들어간 데이터의 위치)를 다음 인덱스로 이동
         * 만약 front가 배열의 마지막 인덱스에 도달했다면, front + 1은 배열의 길이가 되고,
         * % queue.length를 적용하면 0이 되어 큐의 시작 위치로 돌아감 */
        front = (front + 1) % queue.length;
        size--;
        return data;
    }

    // 큐의 맨 앞 데이터를 제거하지 않고 반환 (peek)
    public T peek() {
        return isEmpty() ? null : queue[front];
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 큐에 저장된 요소의 개수를 반환
    public int size() {
        return size;
    }

    // 큐의 모든 요소를 제거
    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        size = 0;
        front = 0;
        rear = 0;
    }

    // 큐의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue[");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % queue.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 큐의 크기가 부족하면 배열의 크기를 두 배로 확장 (원형 구조 유지)
    private void resize() {
        int newSize = queue.length * 2;
        @SuppressWarnings("unchecked")
        T[] newQueue = (T[]) new Object[newSize];
        // front부터 순서대로 새로운 배열에 복사
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size;
    }
}
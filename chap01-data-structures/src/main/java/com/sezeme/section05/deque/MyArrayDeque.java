package com.sezeme.section05.deque;

public class MyArrayDeque<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] deque;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public MyArrayDeque() {
        deque = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Deque의 크기 확인
    public int size() {
        return size;
    }

    // Deque가 비어 있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 앞에 요소 추가
    public void addFirst(T data) {
        if (size == deque.length) {
            resize();
        }
        if (isEmpty()) {
            // 빈 덱이면 front와 rear를 동시에 초기화
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + deque.length) % deque.length;
        }
        deque[front] = data;
        size++;
    }

    // 뒤에 요소 추가
    public void addLast(T data) {
        if (size == deque.length) {
            resize();
        }
        if (isEmpty()) {
            // 빈 덱이면 front와 rear를 동시에 초기화
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % deque.length;
        }
        deque[rear] = data;
        size++;
    }

    // 앞에서 요소 제거
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T data = deque[front];
        deque[front] = null; // 메모리 해제
        front = (front + 1) % deque.length;
        size--;
        if (size == 0) { // 덱이 비면 초기 상태로 재설정
            front = 0;
            rear = -1;
        }
        return data;
    }

    // 뒤에서 요소 제거
    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T data = deque[rear];
        deque[rear] = null; // 메모리 해제
        rear = (rear - 1 + deque.length) % deque.length;
        size--;
        if (size == 0) { // 덱이 비면 초기 상태로 재설정
            front = 0;
            rear = -1;
        }
        return data;
    }

    // 앞의 요소 반환 (제거하지 않음)
    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return deque[front];
    }

    // 뒤의 요소 반환 (제거하지 않음)
    public T getLast() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return deque[rear];
    }

    // 크기 조정 (원형 배열의 순서를 유지하며 확장)
    private void resize() {
        int newCapacity = deque.length * 2;
        @SuppressWarnings("unchecked")
        T[] newDeque = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[(front + i) % deque.length];
        }
        deque = newDeque;
        front = 0;
        rear = size - 1;
    }

    // 덱의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayDeque[");
        for (int i = 0; i < size; i++) {
            sb.append(deque[(front + i) % deque.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
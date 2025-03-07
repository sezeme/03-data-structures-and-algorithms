package com.sezeme.section05.deque;

/* 연결 리스트 기반 덱 예제 */
public class LinkedListDeque<T> {
    private Node<T> front; // 덱의 앞쪽 노드
    private Node<T> rear;  // 덱의 뒤쪽 노드
    private int size;      // 덱에 저장된 요소의 개수

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListDeque() {
        front = null;
        rear = null;
        size = 0;
    }

    // 덱에 요소 추가 (앞쪽)
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, front, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    // 덱에 요소 추가 (뒤쪽)
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null, rear);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // 덱에서 요소 제거 (앞쪽)
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        size--;
        return data;
    }

    // 덱에서 요소 제거 (뒤쪽)
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        size--;
        return data;
    }

    // 덱의 앞쪽 요소 반환 (제거하지 않음)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        return front.data;
    }

    // 덱의 뒤쪽 요소 반환 (제거하지 않음)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        return rear.data;
    }

    // 덱이 비어있는지 확인
    public boolean isEmpty() {
        return front == null;
    }

    // 덱에 저장된 요소의 개수를 반환
    public int size() {
        return size;
    }

    // 덱의 모든 요소를 제거하여 초기 상태로 되돌림
    public void clear() {
        Node<T> current = front;
        while (current != null) {
            Node<T> next = current.next;
            current.data = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        front = rear = null;
        size = 0;
    }

    // 덱의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListDeque[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
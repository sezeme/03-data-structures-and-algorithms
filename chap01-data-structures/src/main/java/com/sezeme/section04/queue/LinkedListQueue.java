package com.sezeme.section04.queue;

/* 연결 리스트 기반 큐 예제 */
public class LinkedListQueue<T> {
    private Node<T> front; // 큐의 앞쪽 노드
    private Node<T> rear;  // 큐의 뒤쪽 노드
    private int size;      // 큐에 저장된 요소의 개수

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // 큐에 요소 추가 (enqueue)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // 큐에서 요소 제거 (dequeue)
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // 큐의 앞쪽 요소 반환 (peek)
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return front.data;
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return front == null;
    }

    // 큐에 저장된 요소의 개수를 반환
    public int size() {
        return size;
    }

    // 큐의 모든 요소를 제거
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    // 큐의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue[");
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
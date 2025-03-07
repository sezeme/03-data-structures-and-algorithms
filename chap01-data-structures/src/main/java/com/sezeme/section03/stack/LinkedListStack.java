package com.sezeme.section03.stack;

import java.util.EmptyStackException;

public class LinkedListStack<T> {
    private Node<T> top; // 스택의 상단 노드
    private int size;    // 스택에 저장된 요소 개수

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    // 스택에 요소 추가
    public void push(T data) {
        top = new Node<>(data, top);
        size++;
    }

    // 스택에서 요소 제거 및 반환
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // 스택의 상단 요소 반환
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == null;
    }

    // 스택에 저장된 요소의 개수를 반환
    public int size() {
        return size;
    }

    // 스택의 모든 요소를 제거
    public void clear() {
        top = null;
        size = 0;
    }

    // 스택의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListStack[");
        Node<T> current = top;
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
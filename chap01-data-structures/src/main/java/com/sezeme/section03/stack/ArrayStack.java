package com.sezeme.section03.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] stack;
    private int top; // 스택의 상단 인덱스

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
        top = -1; // 스택이 비어있음을 의미
    }

    // 스택에 요소 추가
    public void push(T data) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = data;
    }

    // 스택에서 요소 제거 및 반환
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = stack[top];
        stack[top--] = null; // 메모리 해제를 위해 null로 설정
        return data;
    }

    // 스택의 상단 요소 반환
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택에 저장된 요소의 개수를 반환
    public int size() {
        return top + 1;
    }

    // 스택을 비움
    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }

    /* 데이터가 스택의 몇 번째 위치에 있는지 반환 (맨 위가 1)
     * 존재하지 않으면 -1 반환
     */
    public int search(T data) {
        int position = 1;
        // top부터 0까지 순차적으로 검사 (맨 위가 1번째)
        for (int i = top; i >= 0; i--) {
            if (stack[i] == null && data == null) {
                return position;
            } else if (stack[i] != null && stack[i].equals(data)) {
                return position;
            }
            position++;
        }
        return -1;
    }

    // 스택의 크기가 부족하면 배열의 크기를 두 배로 확장
    private void resize() {
        int newSize = stack.length * 2;
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    // 스택의 내용을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack[");
        // 스택의 top부터 순서대로 출력 (top이 가장 먼저 나옴)
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
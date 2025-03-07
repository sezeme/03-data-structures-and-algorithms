package com.sezeme.section03.stack;

import java.util.Stack;

/*
Java Collection Framework에는 Stack 클래스가 있다.
Stack 클래스는 Vector 클래스를 상속하며, Vector는 내부적으로 배열을 사용하여 데이터를 저장한다.
이를 통해 Stack은 배열의 동적 크기 조정 기능을 활용하여 스택의 요소를 관리한다.
*/
public class Application {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 요소 조회
        System.out.println(stack.peek());

        // 요소 제거
        System.out.println(stack.pop());

        // 스택 비어있는지 확인
        System.out.println(stack.isEmpty());
    }
}
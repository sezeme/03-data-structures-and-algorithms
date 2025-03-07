package com.sezeme.section02.list;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /*
       정적 내부 클래스
       - Node 클래스는 노드를 정의하는 데 필요한 데이터와 다음 노드를 가리키는 포인터만 포함
       - 외부 클래스의 인스턴스 상태에 접근하지 않으므로 메모리 효율적
    */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /* 리스트의 끝에 요소를 추가
     * tail 포인터를 사용하여 O(1) 시간에 추가
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {  // 리스트가 비어있는 경우
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /* 지정한 인덱스에 요소를 삽입
     * 삽입 위치가 리스트의 끝이면 tail 포인터를 갱신
     * 시간 복잡도: 최악의 경우 O(n)
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) {  // 헤드에 삽입하는 경우
            newNode.next = head;
            head = newNode;
            if (size == 0) { // 빈 리스트였던 경우 tail도 갱신
                tail = newNode;
            }
        } else if (index == size) {  // 리스트의 끝에 삽입하는 경우
            tail.next = newNode;
            tail = newNode;
        } else {  // 중간에 삽입하는 경우
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /* 인덱스를 통해 요소를 가져오기
     * 인덱스 접근이 불가능하므로 처음부터 순차 탐색
     * 시간 복잡도: O(n)
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /* 지정한 인덱스의 요소를 제거
     * 제거 후 tail 포인터를 적절히 갱신
     * 시간 복잡도: 최악의 경우 O(n)
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement;
        if (index == 0) { // 첫 번째 요소 제거
            removedElement = head.data;
            head = head.next;
            if (head == null) { // 리스트가 비게 되면 tail도 null
                tail = null;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.data;
            current.next = current.next.next;
            if (current.next == null) { // 마지막 요소가 제거된 경우 tail 갱신
                tail = current;
            }
        }
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
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
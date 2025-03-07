package com.sezeme.section07.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 최소 힙(Min Heap) 예제 */
public class MinHeap<T extends Comparable<T>> {
    // 내부 저장소로 ArrayList를 사용하여 힙의 요소들을 저장
    private List<T> heap = new ArrayList<>();

    /* 요소 추가: 데이터를 힙에 추가하고, 힙 속성을 유지하기 위해 위로(heapify-up) 재구성 */
    public void add(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    /* 최소값 추출 : 힙에서 루트(최소값)를 제거하고 반환
     * 제거 후, 마지막 요소를 루트에 대입한 후 아래로(heapify-down) 재구성하여 최소 힙을 유지합
     */
    public T extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    /* 최소값 확인: 힙에서 최소값(루트)을 제거하지 않고 반환 */
    public T getMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    /* 부모 노드와 비교하면서 위로 올라가며(heapify-up) 최소 힙 속성을 유지 */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            // 만약 현재 노드가 부모보다 크거나 같다면 최소 힙 조건을 만족하므로 종료
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /* 자식 노드와 비교하면서 아래로 내려가며(heapify-down) 최소 힙 속성을 유지 */
    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            // 왼쪽 자식이 존재하며, 현재 노드보다 작으면 인덱스 갱신
            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }
            // 오른쪽 자식이 존재하며, 현재 노드보다 작으면 인덱스 갱신
            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }
            // 현재 노드가 최소값이면 종료
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    /* 인덱스에 해당하는 두 요소의 위치를 서로 교환 */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /* 디버깅용 */
    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<>();

        // 초기 세팅
        int[] values = {1, 5, 9, 10, 6, 12};
        for (int value : values) {
            minHeap.add(value);
        }

        // 힙에 값 추가
        System.out.println("초기 힙 상태 : " + minHeap);
        minHeap.add(4);
        System.out.println("4 삽입 후 힙 상태 : " + minHeap);

        // 최소값 확인
        System.out.println("\n현재 최소값: " + minHeap.getMin());

        // 힙에서 최소값 추출하며 상태 출력
        System.out.println("\n최소값 추출");
        while (!minHeap.heap.isEmpty()) {
            int min = minHeap.extractMin();
            System.out.println("추출된 최소값: " + min + ", 현재 힙: " + minHeap);
        }
    }
}

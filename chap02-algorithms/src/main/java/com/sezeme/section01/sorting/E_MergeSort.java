package com.sezeme.section01.sorting;

import java.util.Arrays;

/* 병합 정렬
 * 분할 정복(Divide and Conquer) 방식으로 배열을 반씩 나누어 정렬한 후 병합(Merge)하는 방식이다.
 * 정렬 된 두 개의 배열을 합치는 과정에서 안정 정렬(Stable Sort)의 특성을 유지할 수 있다.
 * 시간 복잡돈ㄴ 항상 O(nlogn)으로 일정하며, 최악의 경우에도 O(nlogn)이다.
 * 하지만 추가 메모리 공간이 필요하므로 메모리 제한적 환경에서는 비효율적일 수 있다.
 * */
public class E_MergeSort {
    /* 문제 : n 개의 저수가 주어졌을 때 병합 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램 작성 */
    public static void solution(int[] arr) {
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("정렬 된 배열 : " + Arrays.toString(arr));

        //객체 타입을 sort하면 TimSort가 동작한다.
        Arrays.sort(new String[]{"apple", "banana"});
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid+1, right);
            merge(arr,temp,left,mid,right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        System.out.println("병합 전 : " +  Arrays.toString(arr));
        System.out.println("left : " + left + ", mid : "+ mid + ", right : " + right);

        // 병합 구간의 배열임시 배열에 복사
        for(int i = left; i<= right ; i++){
            temp[i] = arr[i];
        }

        int leftIndex = left;
        int rightIndex = mid+1;
        int current = left;

        // 두 부분의 배열을 비교하면서 병합하는 과정을 진행한다.
        while(leftIndex <= mid && rightIndex <= right) {
            if(temp[leftIndex] <= temp[rightIndex]) {
                arr[current++] = temp[leftIndex++];
            } else {
                arr[current++] = temp[rightIndex++];
            }
        }

        // 왼쪽 배열에 남은 요소를 복사한다
        // (오른쪽 배열에 남아있을 경우는 이미 제자리에 있으므로 처리할 필요가 없다.)
        while(leftIndex <= mid) {
            arr[current++] = temp[leftIndex++];
        }

        System.out.println("병합 후 : " + Arrays.toString(arr));
        System.out.println("--------------------------------");
    }
}

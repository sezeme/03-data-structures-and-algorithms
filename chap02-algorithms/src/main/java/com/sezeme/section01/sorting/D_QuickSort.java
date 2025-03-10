package com.sezeme.section01.sorting;

import java.util.Arrays;

/* 퀵 정렬
* 기준 값(pyvot)을 선정하여 해당 값을 기준으로 작은 값과 큰 값으로 "분할"하는 방식이다.
* 분할 후 각각의 부분 배열을 재귀적으로 정렬하여 정렬을 완성한다.
* 평균적으로 O(nlogn)의 시간 복잡도를 가지며, 일반적으로 매울 빠르다.
* 하지만 피벗이 최악으로 선택 된 경우 o(N^2)의 성능을 가질 수 있따.
* 메모리 사용이 적고, 대부분의 실제 데이터에서 우수한 성능을 보인다. */
public class D_QuickSort {
    /* 문제 : n 개의 정수가 주어졌을 때, 퀵 정렬 알고리즘을 사용하여 오름차순으로 정렬하는
    * 프로그램을 작성한다. */
    public static void solution(int[] arr) {
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("정렬된 배열 : " + Arrays.toString(arr));

        //Arrays.sort 기능 내부에서 퀵 정렬이 사용된다.
        Arrays.sort(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;

        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex-1);
        quickSort(arr, partitionIndex, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("피벗 " + pivot + " 기준, 인덱스 번ㅁ위 : " + low + " ~ " + high);
        System.out.println("분할 전 배열 : " + Arrays.toString(arr));

        while (low <= high) {
            while(arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;

            if(low <= high) {
                swap(arr, low, high);
                low++;
                high--;
                System.out.println("스왑 : " + Arrays.toString(arr));

            }
        }

        System.out.println("분할 후 배열 : " + Arrays.toString(arr));
        System.out.println("반환 할 pivot 인덱스 : " + low);
        System.out.println("-------------------------------------------");
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package com.sezeme.section01.sorting;

import java.util.Arrays;

/* 선택 정렬
* */
public class B_SelectionSort {
    /* 문제 : n개의 정수가 주어졌을 때 선택 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램 작성 */
    public static void solution(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            System.out.println((i+1) + "번째 : " +Arrays.toString(arr));
            int minIdx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }
}

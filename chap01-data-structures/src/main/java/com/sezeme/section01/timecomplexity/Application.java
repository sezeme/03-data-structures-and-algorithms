package com.sezeme.section01.timecomplexity;

import java.util.Arrays;

/* 시간 복잡도를 이해할 수 있다. */
public class Application {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
        System.out.println(binarySearch(arr, 1));
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(fibonacci(1000));

    }

    /* 상수 시간 O(1) */
    private static int getFirst(int[] arr) {
        return arr[0] + arr[1];
    }

    /* 로그 시간 O(log n) */
    private static int binarySearch(int [] arr, int target) {
        /* 초기 세팅 (배열을 오름차순으로 정렬)
         * 내부적으로 nlogn 만큼의 시간이 걸리지만 지금은 제외 */
        Arrays.sort(arr);

        /* 배열의 처음과 끝을 지정하는 인덱스를 담은 변수 (포인터) */
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == arr[mid]) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }


    /* 선형 시간 O(n) */
    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    /* 지수 시간 O(2^n) */
    // 피보나치 수열을 계산하는 재귀 함수
    public static int fibonacci(int n) {
        // 기본 사례: n이 0 또는 1인 경우
        if (n <= 1) {
            return n;
        }
        // 재귀 사례: 피보나치 수열의 정의에 따라 계산
        return fibonacci(n - 1) + fibonacci(n - 2);
    }









}



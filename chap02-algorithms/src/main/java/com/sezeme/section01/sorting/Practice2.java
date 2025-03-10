package com.sezeme.section01.sorting;

import java.util.Arrays;

/* TimSort 구현하기
 * 삽입 정렬과 병합 정렬의 장점을 결합한 하이브리드 정렬 알고리즘
 * 작은 배열(예: 길이 32 이하)은 삽입 정렬로 정렬한 후, 병합 정렬 방식으로 전체 배열을 병합한다.
 * */
public class Practice2 {
    //TimSort에서 사용할 RUN의 크기 (작은 배열은 삽입 정렬로 정렬)
    private static final int RUN = 32;

    public static void timSort(int[] arr) {
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        // 삽입 정렬
        for (int i = 0; i < arr.length; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, arr.length - 1));
        }

        // 2. 부분 배열을 점진적으로 병합 (크기를 2배씩 증가)
        for (int size = RUN; size < arr.length; size *= 2) {
            for (int left = 0; left < arr.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, arr.length - 1);

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }

        //객체 타입을 sort하면 TimSort가 동작한다.
        Arrays.sort(new String[]{"apple", "banana"});

    }

    /* 주어진 구간에 대해 삽입 정렬을 수행하는 메소드 */
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /* 두 개의 정렬된 부분 배열을 병합하여 하나의 정렬된 배열로 만드는 메소드 */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        System.out.println("병합 전 : " + Arrays.toString(arr));
        System.out.println("left : " + left + ", mid : " + mid + ", right : " + right);

        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < len1) {
            arr[k++] = leftArr[i++];
        }

        while (j < len2) {
            arr[k++] = rightArr[j++];
        }

        System.out.println("병합 후 : " + Arrays.toString(arr));
        System.out.println("--------------------------------");
    }

}

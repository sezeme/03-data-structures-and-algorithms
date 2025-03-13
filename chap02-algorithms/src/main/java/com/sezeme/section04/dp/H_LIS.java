package com.sezeme.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.StringTokenizer;

/* LIS(Longest Increasing Subsequence) : 최대 부분 증가 수열
 * 주어진 수열에서 원래의 순서를 유지하면서, 증가하는 순서를 만족하는
 * 부분 수열 중 가장 긴 수열을 찾는 문제이다.
 * 예를 들어, 수열 {10, 20, 10, 30, 20, 50} 이 있다면
 * 가능한 증가 수열 중 하나인 {10, 20, 30, 50}은 길이가 4인 LIS가 된다.
 * */
public class H_LIS {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;
        // 입력 된 arr 배열의 각 인덱스를 기준 삼아 앞으로 탐색할 반복문
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                // i : 현재 기준 인덱스, j : 비교할 앞의 인덱스
                if(arr[i] > arr[j]) {
                    // 현재 값은 증가 수열의 일부라고 판단 dp[i] = dp[j] + 1
                    // 10(1) 20(2) 10(1) 30 -> 2 + 1 = 3이 30에 들어갈 수 있도록 하려면
                    // dp[i]와 dp[j]+1 중 큰 값을 골라서 계속 업데이트 해야 한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

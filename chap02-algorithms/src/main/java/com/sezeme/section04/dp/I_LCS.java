package com.sezeme.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* LCS(Longest Common Subsequence) : 최장 공통 부분 수열
 * 두 개의 문자열(또는 수열)에서, 각 문자열의 원래 순서를 유지하면서
 * 공통으로 나타나는 부분 수열 중에서 가장 긴 수열을 찾는 문제이다.
 * 예를 들어, 문자열 "ABCBDAB"과 "BDCABA"가 주어졌을 때,
 * 공통 부분 수열인 "BCBA" 또는 "BDAB" 등이 있을 수 있으며, 이들 중 길이가 가장 긴 수열을 찾는다.
 * */
public class I_LCS {

    static char[] arr1;
    static char[] arr2;
    static Integer[][] dp;

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        dp = new Integer[arr1.length][arr2.length];

        /* 탑 다운 방식 수행 (재귀 호출) */
        return lcs(arr1.length - 1, arr2.length - 1);
    }

    static int lcs(int x, int y) {
        //재귀 호출 종료 조건
        if (x < 0 || y < 0) return 0;
        // 연산 되어 있지 않은 경우에만 연산을 수행
        if (dp[x][y] == null) {
            if(arr1[x] == arr2[y]){
                //서로 같은 문자가 발견되었다면?
                // 이전까지의 문자열의 최적해 값이 x-1, y-1 인덱스에 있고 1을 추가
                dp[x][y] = lcs(x-1, y-1) + 1;
            } else {
                //같은 문자가 아니라면?
                // x방향 또는 y방향에서 큰 값을 반영한다.
                dp[x][y] = Math.max(lcs(x-1, y), lcs(x, y-1));
            }
        }
        return dp[x][y];
    }
}

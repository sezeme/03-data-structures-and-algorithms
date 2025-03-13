package com.sezeme.section04.dp;

public class A_Fibonacci {
    /* 기본 재귀 함수 */
    public static int getFibonacciNumber(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;

        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }

    /* DP - Top Down 방식
     * 메모이제이션(Memoization) : 연산 결과를 메모리에 저장해 두었다가 동일한 연산을 반복할 때
     * 이전에 계산 된 결과를 재활용하는 기법
     * */
    static int[] dp = new int[50];
    public static int getFibonacciNumberDP(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;

        // 1. 확인 : 함수 호출 전 해당 입력에 대한 결과가 이미 저장 되어 있는지
        if(dp[n] == 0) {
            // 2. 저장 : 계산 되지 않은 값은 연산 후 특정 자료 구조에 저장
            dp[n] = getFibonacciNumberDP(n - 1) + getFibonacciNumberDP(n - 2);
        }

        // 3. 재활용 : 저장 된 결과가 있다면 다시 계산하지 않고 저장 된 값을 반환
        return dp[n];
    }

    /* DP - Bottom Up 방식
     * 타뷸레이션(Tabulation) : 문제를 부분 문제로 나눈 뒤 작은 문제부터 차례로 그 결과를 테이블에 저장하는 방식
     * */
    static int getFibonacciNumberIter(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        if(n == 0) return arr[0];
        else if(n == 1) return arr[1];
        else {
            for(int i = 2; i <= n; i++) arr[i] = arr[i-1] + arr[i-2];
            return arr[n];
        }
    }

}

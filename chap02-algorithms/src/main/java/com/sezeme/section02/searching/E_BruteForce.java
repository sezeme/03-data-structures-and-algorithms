package com.sezeme.section02.searching;

import java.util.StringTokenizer;

/* 완전 탐색(BruteForce) + 백트래킹 (Back Tracking)
 * 주어진 정수들의 모든 순열(순서 있는 조합)을 구하는 문제
 * 가능한 모든 경우의 수를 탐색하는 '완전 탐색' 방식을 사용하지만,
 * 백트래킹을 활용하여 이미 사용한 정수를 다시 선택하지 않음으로써 가지치기를 수행하고
 * 불필요한 탐색을 줄여 효율적으로 모든 순열의 갯수를 구한다.
 * */
public class E_BruteForce {

    // 순열의 총 개수를 저장할 변수
    static int count = 0;
    // 입력 받은 정수 배열
    static int[] nums;
    // 각 정수의 사용 여부를 체크하는 배열
    static boolean[] visited;

    public static Integer solution(String input) {
        StringTokenizer st = new StringTokenizer(input.trim());
        int n = st.countTokens();
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        // 순열의 개수 초기화
        count = 0;
        // 깊이 0에서부터 backtrack 호출
        backtrack(0, n);

        return count;
    }
    /* depth : 현재까지 선택 된 정수의 개수
     * n : 전체 정수 개수 */
    private static void backtrack(int depth, int n) {
        if(depth == n) {
            /* 모든 정수를 한 번씩 사용한 것이므로 유효한 순열 1개를 찾았다는 의미 */
            count++;
            return;
        }
        /* 조건문에 걸리지 않았다는 것은 사용하지 않은 정수를 하나씩 선택하여
        재귀적으로 다음 정수를 선택해야 한다는 의미 */
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {   // 이미 선택한 정수는 건너뛰어 가지치기 한다
                visited[i] = true;
                backtrack(depth + 1, n);
                visited[i] = false; // 백트래킹 : 선택했던 정수의 사용 상태를 원상 복구시킴
            }
        }
    }





}

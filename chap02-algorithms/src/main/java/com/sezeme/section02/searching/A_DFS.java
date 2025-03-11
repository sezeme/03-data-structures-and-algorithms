package com.sezeme.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 깊이 우선 탐색 (Depth-First Search)
* 후입 선출 구조의 stack을 활용하거나 재귀 호출을 이용한다.
* 시작 노드에서 출발해 한 방향으로 갈 수 있는 만큼 깊이 탐색한 후,
* 더 이상 진행할 수 없을 때 이전 분기점으로 돌아가 다른 경로를 탐색하는 알고리즘이다.
* */
public class A_DFS {

    /* 웜 바이러스에 걸리게 되는 컴퓨터의 수 구하기 문제 */
    static int count;
    static int node, edge;
    static int[][] map;
    static boolean[] visit;
    public static Integer solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        /* 그래프의 간선 연결 정보를 이차원 배열로 표현 */
        map = new int[node+1][node+1]; //0번 인덱스 제외하고 사용

        /* 방문 배열 생성 */
        visit = new boolean[node + 1];

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프이므로 둘 다 1로 설정
            map[a][b] = map[b][a] = 1;

        }
//        dfsRecursive(1);
        dfsStack(1);
        return count;
    }

    /* 재귀 함수로 DFS 알고리즘을 구현할 메소드 */
    public static void dfsRecursive(int start) {
        /* 해당 노드를 방문했으므로 방문 배열에 표기 */
        visit[start] = true;
        /* start 노드의 이웃을 탐색하는 과정 */
        for(int i = 1; i <= node ; i ++){

            if(map[start][i] == 1 && !visit[i]){
                /* 바이러스를 전파할 이웃 노드 컴퓨터를 찾은 것이므로 count를 증가시키고
                * 해당 이웃 노드를 방문해서 다시 이웃노드를 재귀적으로 탐색한다.*/
                count++;
                dfsRecursive(i);
            }
        }
    }

    public static void dfsStack(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for(int i = 0; i<node; i++){
                if(map[current][i] == 1 && !visit[i]) {
                    stack.push(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }
}

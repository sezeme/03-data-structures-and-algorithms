package com.sezeme.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class F_FindTreeParent {

    static int N;
    static List<Integer>[] list;
    static int[] parent;
    static boolean[] visited;

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }

        /* N - 1 개의 줄 입력 처리 */
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
//        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < parent.length ; i++){
            sb.append(parent[i]).append(" ");
        }

        return sb.toString();
    }

    static void dfs(int parentNode) {
        visited[parentNode] = true;

        for(int childNode : list[parentNode]) {
            if(!visited[childNode]) {
                parent[childNode] = parentNode;
                dfs(childNode);
            }
        }
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while(!queue.isEmpty()) {
            int parentNode = queue.poll();
            for(int childNode : list[parentNode]) {
                if(!visited[childNode]) {
                    visited[childNode] = true;
                    parent[childNode] = parentNode;
                    queue.offer(childNode);
                }
            }
        }
    }
}

package com.sezeme.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 너비 우선 탐색(Breadth-First Search)
 * 선입 선출 구조의 queue를 활용한다.
 * 시작 노드에서 출발해서 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다. */
public class B_BFS {

    /* 배추 밭에 필요한 배추 지렁이 갯수 구하는 문제
     * x, y 좌표를 활용한 탐색 문제를 해결할 수 있다.
     * */
    static int M, N, K;

    static int[][] map;
    static boolean[][] visit;
    static int count;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //현재좌표
    static int cx, cy;

    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[M][N];
        visit = new boolean[M][N];

        /* 배추 심기 */
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        count = 0;

        /* 배추 찾기 */
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                /* 방문하지 않은 위치에 배추가 심어져있다면 지렁이를 심는다. */
                if (map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    /* 해당 위치에 붙어있는 배추밭을 방문 체크 (붙어있는 배추 묶음을 파악 */
                    bfs(i, j);
                }
            }
        }

        return 0;
    }

    private static void bfs(int x, int y) {
        visit[x][y] = true;
        q.offer(new Node(x, y));

        /* 연속적으로 상하좌우에 배추가 심어져 있다면 해당 위치를 방문한 것으로 체크하고
         * queue를 통해 탐색 진행 */
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                cx = node.x + dx[i];
                cy = node.y + dy[i];

                /* 지금 보는 방향이 좌표로서 존재하고, 방문한 적이 없고, 배추가 심어져 있다면 */
                if(rangeCheck() && !visit[cx][cy] && map[cx][cy] == 1) {
                    q.offer(new Node(cx, cy));
                    visit[cx][cy] = true;
                }
            }
        }
    }

    static boolean rangeCheck() {
        return !(cx < 0 || cx > M || cy < 0 || cy > N);
    }
}

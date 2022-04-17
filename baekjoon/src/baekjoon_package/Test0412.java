package baekjoon_package;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test0412 {

    private static boolean[] visited;
    private static int n, line, cnt=0;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        line = sc.nextInt();
        visited = new boolean[101];
        arr = new int[n+1][n+1];

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        bfs();

        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int start = q.poll();
            for (int i = 1; i < n+1; i++) {
                if (arr[start][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}

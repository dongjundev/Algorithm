package baekjoon_package;

import java.util.Scanner;

public class Test1743 {

    static int n, m, k;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0, cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[n][m];
        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x - 1][y - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt = 0;
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX > -1 && nextX < n && nextY > -1 && nextY < m && visited[nextX][nextY] == false && arr[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
            answer = Math.max(cnt, answer);
        }
    }
}

package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14500 {
    static int[][] arr;
    static int N;
    static int M;
    static int max = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
                check(i, j);
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= N || ny >= M || nx < 0 || ny < 0 || visited[nx][ny]) {
                continue;
            }

            dfs(nx, ny, cnt + 1, sum + arr[x][y]);
        }

        visited[x][y] = false;
    }

    static void check(int y, int x) {
        if (y < N - 2 && x < M - 1)
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]);

        if (y < N - 2 && x > 0)
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]);

        if (y < N - 1 && x < M - 2)
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]);

        if (y > 0 && x < M - 2)
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1]);
    }
}

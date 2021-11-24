package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2468 {
    static int N, cnt = 0, MAX = Integer.MIN_VALUE;
    static boolean[][] visit;
    static int[][] arr, tmpArr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 1; h <= 100; h++) {
            visit = new boolean[N][N];
            tmpArr = new int[N][N];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] <= h)
                        tmpArr[i][j] = 0;
                    else
                        tmpArr[i][j] = 1;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == false && tmpArr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            MAX = Math.max(MAX,cnt);
        }

        System.out.println(MAX);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX > -1 && nextX < N && nextY > -1 && nextY < N) {
                if (visit[nextX][nextY] == false && tmpArr[nextX][nextY] == 1) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}


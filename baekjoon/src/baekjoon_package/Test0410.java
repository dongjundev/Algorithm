package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test0410 {

    private static int bTotal = 0, wTotal = 0;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int m, n, cnt;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j);
                System.out.println(arr[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(arr[i][j], i, j);

                    if (arr[i][j] == 'B') {
                        bTotal += cnt*cnt;
                    }
                    else if (arr[i][j] == 'W') {
                        wTotal += cnt*cnt;
                    }
                }
            }
        }

        System.out.println(wTotal +" "+bTotal);
    }

    public static void dfs(char ch, int x, int y) {
        cnt++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if ( nextX > -1 && nextX < n && nextY > -1 && nextY < m  && arr[nextX][nextY] == ch && visited[nextX][nextY] == false ) {
                dfs(arr[nextX][nextY], nextX, nextY);
            }
        }
    }
}

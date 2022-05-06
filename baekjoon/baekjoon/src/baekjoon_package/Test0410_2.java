package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test0410_2 {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int m,n;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(arr[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] start = q.poll();

            if (start[0] == n - 1 && start[1] == m - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = start[0] + dx[i];
                int nextY = start[1] + dy[i];

                if (nextX > -1 && nextX < n && nextY > -1 && nextY < m && arr[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                    q.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[start[0]][start[1]] + 1;
                }
            }
        }
    }
}

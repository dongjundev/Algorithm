package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test16930 {

    private static int n, m, k;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] cnt;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cnt = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '.') {
                    arr[i][j] = 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        Dot Start = new Dot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        Dot End = new Dot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        bfs(Start);

        if (cnt[End.x][End.y] == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(cnt[End.x][End.y]);
        return;

    }

    static void bfs(Dot start) {
        Queue<Dot> q = new LinkedList();
        q.offer(start);
        visited[start.x][start.y] = true;
        cnt[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Dot poll = q.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= k; j++) {
                    int nextX = poll.x + dx[i] * j;
                    int nextY = poll.y + dy[i] * j;
                    if (nextX > -1 && nextX < n && nextY > -1 && nextY < m && visited[nextX][nextY] == false && arr[nextX][nextY] == 1) {
                        q.offer(new Dot(nextX, nextY));
                        visited[nextX][nextY] = true;
                        cnt[nextX][nextY] = cnt[poll.x][poll.y] + 1;
                    }
                    else
                        break;
                }
            }
        }
    }
}

class Dot {
    int x;
    int y;

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2206 {

    private static int n, m;
    private static int[][] map;
    private static int[][] weight;
    private static boolean[][][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m][2];
        map = new int[n][m];
        weight = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        q.offer(new Loc(0, 0, false));
        weight[0][0] = 1;

        while (!q.isEmpty()) {
            Loc pollLoc = q.poll();
            int x = pollLoc.x;
            int y = pollLoc.y;

            if (x == n - 1 && y == m - 1) {
                System.out.println(weight[x][y]);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }

                if (map[xx][yy] == 0) { //벽이 아니면
                    if (!pollLoc.destroyed && !visited[xx][yy][0]) { //부신 벽이 없으면
                        q.offer(new Loc(xx, yy, false));
                        visited[xx][yy][0] = true;
                        weight[xx][yy] = weight[x][y] + 1;
                    } else if (pollLoc.destroyed && !visited[xx][yy][1]) { //부신 벽이 있으면
                        q.offer(new Loc(xx, yy, true));
                        visited[xx][yy][1] = true;
                        weight[xx][yy] = weight[x][y] + 1;
                    }
                } else if (map[xx][yy] == 1) { //벽이면 부신다
                    if (!pollLoc.destroyed) {
                        q.offer(new Loc(xx, yy, true));
                        visited[xx][yy][1] = true;
                        weight[xx][yy] = weight[x][y] + 1;
                    }
                }
            }
        }
    }
}

class Loc {
    int x;
    int y;
    boolean destroyed;

    public Loc(int x, int y, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.destroyed = destroyed;
    }

    @Override
    public String toString() {
        return "Loc{" +
                "x=" + x +
                ", y=" + y +
                ", destroyed=" + destroyed +
                '}';
    }
}

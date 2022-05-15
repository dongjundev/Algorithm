import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    private static boolean[][] visited;
    private static int[][] cloneMap;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, m;

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        cloneMap = maps.clone();

        bfs(0, 0);

        if (cloneMap[n - 1][m - 1] == 0 || cloneMap[n - 1][m - 1] == 1) {
            return -1;
        }

        answer = cloneMap[n - 1][m - 1];

        return answer;
    }

    private void bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                else if (cloneMap[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                    q.offer(new Loc(nextX, nextY));
                    visited[nextX][nextY] = true;
                    cloneMap[nextX][nextY] = cloneMap[poll.x][poll.y] + 1;
                }
            }
        }
    }
}

class Loc {
    int x;
    int y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

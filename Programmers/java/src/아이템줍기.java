import java.util.*;

public class 아이템줍기 {

    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    List<Rect> rectList = new ArrayList<Rect>();

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for (int i = 0; i < rectangle.length; i++) {
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;

            for (int mapX = ly; mapX <= ry; mapX++) {
                map[mapX][lx] = -1;
                map[mapX][rx] = -1;
            }

            for (int mapY = lx; mapY <= rx; mapY++) {
                map[ly][mapY] = -1;
                map[ry][mapY] = -1;
            }

            rectList.add(new Rect(lx, ly, rx, ry));
        }

        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        answer = map[itemY * 2][itemX * 2];

        return answer/2;
    }

    public void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(characterY, characterX));
        map[characterY][characterX] = 0;
        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {
            Loc poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            if (x == itemY && y == itemX) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;

                if (map[nx][ny] == -1 && !visited[nx][ny] && check(nx, ny)) {
                    q.add(new Loc(nx, ny));
                    map[nx][ny] = map[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    //이어진 직사각형 내부에 좌표가 있는지 확인
    public boolean check(int nx, int ny) {
        for (Rect r : rectList) {
            if (r.lx < ny && r.ly < nx && r.rx > ny && r.ry > nx) return false;
        }
        return true;
    }

    class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Rect {
        int lx;
        int ly;
        int rx;
        int ry;

        public Rect(int lx, int ly, int rx, int ry) {
            this.lx = lx;
            this.ly = ly;
            this.rx = rx;
            this.ry = ry;
        }
    }
}

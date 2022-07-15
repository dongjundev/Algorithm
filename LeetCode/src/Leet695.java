public class Leet695 {
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int cnt = 0;

    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    cnt = 0;
                    dfs(i, j, grid);
                    System.out.println(cnt);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        return answer;
    }

    private void dfs(int x, int y, int[][] grid) {
        visited[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;

            if (visited[nx][ny] == false && grid[nx][ny] == 1) {
                dfs(nx, ny, grid);
            }
        }
    }
}

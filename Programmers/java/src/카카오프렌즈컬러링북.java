public class 카카오프렌즈컬러링북 {

    private boolean[][] visited;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private int cnt = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && picture[i][j] != 0) {
                    cnt = 0;
                    dfs(picture, i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void dfs(int[][] picture, int x, int y) {
        visited[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
                continue;

            if (visited[nx][ny] == false && picture[x][y] == picture[nx][ny]) {
                dfs(picture, nx, ny);
            }
        }
    }
}

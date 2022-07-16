//public class Leet576 {
//    int[] dx = {1, -1, 0, 0};
//    int[] dy = {0, 0, 1, -1};
//    int answer = 0;
//
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        dfs(startRow, startColumn, m, n, maxMove, 0);
//        return answer;
//    }
//
//    private void dfs(int startR, int startC, int m, int n, int maxMove, int cnt) {
//        if (cnt > maxMove) {
//            return;
//        }
//
//        if (startR < 0 || startR > m-1 || startC < 0 || startC > n-1) {
//            answer++;
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nStartR = startR + dx[i];
//            int nStartC = startC + dy[i];
//
//            dfs(nStartR, nStartC, m, n, maxMove, cnt + 1);
//        }
//    }
//}
class Leet576 {
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N + 1][m][n];
        for(int k = 1; k <= N; k++){
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                    // (r, c) means the current position of a node.
                    int tempRow = 0, tempCol = 0;
                    for(int d = 0; d < 4; d++){
                        // (tempRow, tempCol) means the next posible position
                        tempRow = r + dir[d][0];
                        tempCol = c + dir[d][1];
                        if(tempRow < 0 || tempRow >= m || tempCol < 0 || tempCol >= n){
                            // if next position is out of boundary, current index add 1.
                            dp[k][r][c] += 1;
                        }else{
                            // if next position is within the boundary, we add that ways to current one.
                            dp[k][r][c] = (dp[k][r][c] + dp[k - 1][tempRow][tempCol]) % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[N][i][j];
    }
}
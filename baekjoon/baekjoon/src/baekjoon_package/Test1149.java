package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1149 {
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int MIN = -1;

        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);

            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        MIN = Math.min(Math.min(dpCal(N - 1, 0), dpCal(N - 1, 1)), MIN);

        System.out.println(MIN);
    }

    static int dpCal(int x, int y) {
        if (dp[x][y] == 0) {
            if (y == 0) {
                dp[x][y] = Math.min(dpCal(x - 1, 1), dpCal(x - 1, 2)) + cost[x][0];
            } else if (y == 1) {
                dp[x][y] = Math.min(dpCal(x - 1, 0), dpCal(x - 1, 2)) + cost[x][1];
            } else if (y == 2) {
                dp[x][y] = Math.min(dpCal(x - 1, 0), dpCal(x - 1, 1)) + cost[x][2];
            }
        }

        return dp[x][y];
    }
}

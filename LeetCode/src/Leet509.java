import java.util.Arrays;

public class Leet509 {
    int dp[];

    public int fib(int n) {
        dp = new int[31];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        return calDp(n);
    }

    public int calDp(int n) {
        if (dp[n] == -1) {
            dp[n] = calDp(n - 1) + calDp(n - 2);
        }

        return dp[n];
    }
}

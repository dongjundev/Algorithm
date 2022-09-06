public class Leet70 {
    int[] dp = new int[46];

    public int climbStairs(int n) {
        dp[1] = 1;
        dp[2] = 2;

        return recur(n);
    }

    public int recur(int n) {
        if (dp[n] == 0) {
            dp[n] = recur(n - 2) + recur(n - 1);
        }

        return dp[n];
    }
}

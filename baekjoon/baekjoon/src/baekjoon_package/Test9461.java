package baekjoon_package;

import java.util.Arrays;
import java.util.Scanner;

public class Test9461 {
    private static Long[] dp = new Long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Arrays.fill(dp, -1l);
        dp[0] = 0l;
        dp[1] = 1l;
        dp[2] = 1l;
        dp[3] = 1l;

        for (int i = 0; i < T; i++) {
            int p = sc.nextInt();
            System.out.println(padovan(p));
        }
    }

    private static long padovan(int p) {
        if (dp[p] == -1) {
            return dp[p] = padovan(p-3) + padovan(p-2);
        }

        return dp[p];
    }
}

package baekjoon_package;

import java.util.Scanner;

public class Test1904 {

    static int[] dp = new int[1000001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(tile(N));
    }

    static int tile(int n) {

        if (dp[n] == -1) {
            dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;
        }

        return dp[n];
    }
}

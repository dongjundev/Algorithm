package baekjoon_package;
import java.util.*;

public class Test1003 {
	static int t=0, n=0;
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			fib(n);
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}
	
	public static Integer[] fib(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
			dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
		}
		return dp[n];
	}
}

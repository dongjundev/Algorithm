package baekjoon_package;
import java.util.Scanner;

public class Test1014 {
	private static int N,M;
	private static int dp[][];
	private static boolean obstacle[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {
			N = sc.nextInt();
			M = sc.nextInt();
			dp = new int [N][M];
			
			for(int i=0; i<N; i++) {
				String input = sc.nextLine();
				for(int j=0; j<M; j++) {
					if(input.substring(j, j+1).equals("x")) obstacle[i][j] = true;
				}
			}
			
		}
	}

}

package baekjoon_package;
import java.util.*;

public class Test1015 {
	static class Number{
		public int n, idx;
		public Number(int n, int idx) {
			this.n = n;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str1[] = sc.nextLine().split(" ");
		Number A[] = new Number[N];
		for(int i = 0; i < N; i++) {
			A[i] = new Number(Integer.parseInt(str1[i]), i);
		}
		int B[] = new int[N];
		for(int i=0; i<N; i++) {
			int min = A[0].n;
			int minIdx = 0;
			
		}

	}

}

package baekjoon_package;
import java.util.Scanner;

public class Test1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t,a,b,i,j,k,d[][];
		t = sc.nextInt();
		while(t-->0) {
			a = sc.nextInt();
			b = sc.nextInt();
			d = new int[a+1][b+1];
			for(i=0; i<=b; i++)	d[1][i] = i;
			for(i=2; i<=a; i++)
				for(j=i; j<=b; j++)
					for(k=j; k>=i; k--)
						d[i][j]+=d[i-1][k-1];
		System.out.println(d[a][b]);
		}
	}

}

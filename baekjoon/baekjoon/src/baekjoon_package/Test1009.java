package baekjoon_package;
import java.util.Scanner;

public class Test1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b,n,r;
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			r = 1;
			for(int j=0; j<b; j++) {
				r = (r*a)%10;
			}
			if(r == 0)
				r = 10;			
			System.out.println(r);
			}
		}

}

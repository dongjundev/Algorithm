package baekjoon_package;
import java.util.Scanner;

public class Test1011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 
		int T = in.nextInt();	// 테스트 케이스 
		
		for(int i = 0; i < T; i++) {
        
			int X = in.nextInt();
			int Y = in.nextInt();
			
			int distance = Y - X;	// 거리
			
			int max = (int)Math.sqrt(distance);	// 소수점 버림
            
			if(max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			}
			else if(distance <= max * max + max) {
				System.out.println(max * 2);
			}
			else {
				System.out.println(max * 2 + 1);
			}
			
		}
	}

}

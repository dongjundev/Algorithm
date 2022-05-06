package baekjoon_package;
import java.util.*;

public class StackTest {
		
	public static void main(String[] args){
		String s ="";
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		s = sc.next();
		int c=0;
		
//		Stack<String> stack = new Stack<String>();
//		stack.push(s.split(""));
//		System.out.println(stack.pop());
		
		String arr[] = s.split("");
		for(int i=0; i<arr.length; i++) {
			//System.out.println(arr[i]);
			if(arr[i].equals("1")) {
				//System.out.println(i);
				if(i==0 || arr[i-1].equals(arr[i])) {
					c++;
				}
					
			}
			//System.out.println(c);
		}
		System.out.println(c);
	}
}


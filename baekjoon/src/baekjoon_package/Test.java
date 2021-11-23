package baekjoon_package;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Test {
	public int fac(int n) {
		if (n<=0) return 1;
		else return n*fac(n-1);
	}
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        Test test = new Test();
//        int a;
//        System.out.print("숫자 입력: ");
//        a = scanner.nextInt();
//        System.out.print(test.fac(a));
        String[] arr = {"hi", "bye", "hello"};
        List<String> list = Arrays.asList(arr);

        list.forEach(x -> System.out.println(x));
    }
}

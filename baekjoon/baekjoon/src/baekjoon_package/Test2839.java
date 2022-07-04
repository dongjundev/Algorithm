package baekjoon_package;

import java.util.Scanner;

public class Test2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                answer += n/5;
                System.out.println(answer);
                return;
            } else if (n == 4 || n == 7) {
                System.out.println(-1);
                return;
            } else {
                n -= 3;
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}

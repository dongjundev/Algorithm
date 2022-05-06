package baekjoon_package;

import java.util.Scanner;
import java.util.Stack;

public class Test10773 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if (p != 0) {
                stack.push(p);
            } else {
                stack.pop();
            }
        }

        for (Integer i : stack) {
            sum += i;
        }

        System.out.println(sum);
    }
}

package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test10828 {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "push":
                    stack.push(arr[1]);
                    break;

                case "pop":
                    try {
                        System.out.println(stack.pop());
                    }
                    catch (Exception e) {
                        System.out.println(-1);
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if (stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "top":
                    try {
                        System.out.println(stack.peek());
                    } catch (Exception e) {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}

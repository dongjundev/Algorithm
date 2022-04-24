package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                }
                else{
                    if (stack.isEmpty()) {
                        stack.push(str.charAt(j));
                        break;
                    }
                    stack.pop();
                }
            }

            if(stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");

            stack.clear();
        }
    }
}

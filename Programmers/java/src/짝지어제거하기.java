import java.util.*;

class 짝지어제거하기{
    public int solution(String s) {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        char[] s_arr = s.toCharArray();

        for (char c : s_arr) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        if (stack.empty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}

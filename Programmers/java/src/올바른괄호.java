import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                st.push(c);
            } else {
                try {
                    st.pop();
                } catch (Exception e) {
                    return false;
                }
            }
        }

        if (!st.isEmpty()) answer = false;

        return answer;
    }
}

import java.util.Stack;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();

        for (int a : arr) {
            if (st.isEmpty() || st.peek() != a) {
                st.push(a);
            }
        }

        answer = st.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

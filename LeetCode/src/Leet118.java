import java.util.ArrayList;
import java.util.List;

public class Leet118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        answer.add(inner);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousInner = answer.get(i - 1);
            int n = previousInner.size();
            inner = new ArrayList<>();
            inner.add(1);

            for (int j = 1; j < n; j++) {
                inner.add(previousInner.get(j - 1) + previousInner.get(j));
            }

            inner.add(1);
            answer.add(inner);
        }

        return answer;
    }
}

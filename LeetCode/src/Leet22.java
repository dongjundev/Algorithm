import java.util.ArrayList;
import java.util.List;

public class Leet22 {
    private StringBuilder sb = new StringBuilder();
    private List<String> list = new ArrayList<>();

    public  List<String> generateParenthesis(int n) {
        dfs(0, 0, 0, n);
        return list;
    }

    public void dfs(int depth, int openBracket, int closeBracket, int n) {
        if (depth == n * 2) {
            list.add(sb.toString());
            return;
        }

        if (openBracket < n) {
            sb.append("(");
            dfs(depth + 1, openBracket + 1, closeBracket, n);
            sb.setLength(sb.length() - 1);
        }

        if (openBracket > closeBracket) {
            sb.append(")");
            dfs(depth + 1, openBracket, closeBracket + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}

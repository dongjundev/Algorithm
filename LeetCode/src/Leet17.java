import java.util.ArrayList;
import java.util.List;

public class Leet17 {
    public String[] letters = {"", "", "abc", "def", "ghi", "kjl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();

        if (digits.length() > 0) {
            comb(0, new StringBuilder(), digits.toCharArray());
        }
        return result;
    }

    public void comb(int pick, StringBuilder sb, char[] order) {
        if (pick == order.length) {
            result.add(sb.toString());
            return;
        }

        char[] charArr = letters[order[pick]-'0'].toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            sb.append(charArr[i]);
            comb(pick + 1, sb, order);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

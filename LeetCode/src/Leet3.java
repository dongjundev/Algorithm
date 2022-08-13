import java.util.HashSet;
import java.util.Set;

public class Leet3 {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0)
            return 0;

        int[] dp = new int[s.length()];
        Set<Character> set;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
            }
        }

        return max;
    }
}

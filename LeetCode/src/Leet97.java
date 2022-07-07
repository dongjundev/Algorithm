import java.util.Arrays;

public class Leet97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        int[][] mem = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); ++i) {
            Arrays.fill(mem[i], -1);
        }
        return helper(s1, 0, s2, 0, s3, 0, mem);
    }

    boolean helper(String s1, int i1, String s2, int i2, String s3, int i3, int[][] mem) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }
        if (i3 == s3.length())  return false;
        if (mem[i1][i2] >= 0)   return mem[i1][i2] == 1;
        if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
            if (helper(s1, i1+1, s2, i2, s3, i3+1, mem)) {
                mem[i1+1][i2] = 1;
                return true;
            } else {
                mem[i1+1][i2] = 0;
            }
        }
        if (i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
            if (helper(s1, i1, s2, i2+1, s3, i3+1, mem)) {
                mem[i1][i2+1] = 1;
                return true;
            } else {
                mem[i1][i2+1] = 0;
            }
        }
        return false;
    }
}

import java.util.Arrays;

public class Leet14 {
    public String longestCommonPrefix(String[] strs) {
        int idx=0;

        while(idx<strs[0].length()){
            char c =strs[0].charAt(idx);
            int i=0;

            while(i<strs.length && strs[i].length()>idx && strs[i].charAt(idx)==c){
                i++;
                continue;
            }

            if(i==strs.length){
                idx++;
            } else {
                break;
            }
        }

        return strs[0].substring(0, idx);
    }
}

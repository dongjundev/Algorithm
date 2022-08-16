public class Leet13 {
    final static int[] val = {900, 400, 90, 40, 9, 4};
    final static String[] rom = {"CM", "CD", "XC", "XL", "IX", "IV"};

    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < 6; i++) {
            while (s.indexOf(rom[i])!=-1) {
                ans += val[i];
                s = s.replace(rom[i], "");
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'I') ans += 1;
            else if(c == 'V') ans += 5;
            else if(c == 'X') ans += 10;
            else if(c == 'L') ans += 50;
            else if(c == 'C') ans += 100;
            else if(c == 'D') ans += 500;
            else if(c == 'M') ans += 1000;
        }

        return ans;
    }
}

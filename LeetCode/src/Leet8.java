public class Leet8 {
    public int myAtoi(String s) {
        boolean minus = false;
        String result = "";

        if (s == "") {
            return 0;
        }

        s = s.trim();

        char[] chars = s.toCharArray();

        for (int i=0; i<chars.length; i++) {
            if (i==0) {
                if (chars[i] == '-') {
                    minus = true;
                    continue;
                } else if (chars[i] == '+') {
                    continue;
                }
            }

            if (String.valueOf(chars[i]).matches("^[^0-9]*$")) {
                break;
            }
            result += chars[i];
        }

        if (result == "") {
            return 0;
        }

        double l = Double.parseDouble(result);

        if (minus) {
            l *= -1;
        }

        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) l;
    }

    public int myAtoi2(String s) {
        int num=0;
        boolean isPositive=true, numeric=false;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                int digit=ch-'0';
                if(num>(Integer.MAX_VALUE-digit)/10)
                    return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
                num=num*10+digit;
                numeric=true;
            }else if(numeric)
                break;
            else if(ch=='-' || ch=='+'){
                isPositive=ch=='+'?true:false;
                numeric=true;
            }
            else if(ch!=' ')
                break;
        }

        if(!isPositive)
            return -num;
        return num;
    }
}

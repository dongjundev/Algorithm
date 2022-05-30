public class 괄호변환 {

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    static public String solution(String p) {
        if (check(p))
            return p;

        String answer = seg(p);

        return answer;
    }

    static private boolean check(String str) {
        int cnt = 0;

        if (str.charAt(0) == ')') {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    cnt++;
                } else {
                    cnt--;
                    if (cnt < 0)
                        return false;
                }

            }
        }

        return true;
    }

    static private String seg(String str) {
        int cnt = 0;
        String u = null;
        String v = null;

        if (str.length() == 0)
            return "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') cnt++;
            else cnt--;

            if (cnt == 0) {
                u = str.substring(0, i + 1);
                v = str.substring(i + 1);

                if (check(u)) {
                    return u + seg(v);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(seg(v));
                    sb.append(")");

                    for (int j = 1; j < u.length() - 1; j++) {
                        char c2 = u.charAt(j);
                        if (c2 == '(') sb.append(')');
                        else sb.append('(');
                    }

                    return sb.toString();
                }
            }
        }

        return u;
    }
}

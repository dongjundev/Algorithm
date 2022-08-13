public class Leet7 {
    public int reverse(int x) {
        boolean f = false;
        long input = x;

        if (x < 0) {
            f = true;
            input *= -1;
        }

        String s = String.valueOf(input);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();

        Long answer =  Long.parseLong(String.valueOf(sb));

        if (Math.pow(2, 31) * -1 > answer || Math.pow(2, 31) - 1 < answer) {
            return 0;
        }

        if (f) {
            return answer.intValue()*-1;
        }

        return answer.intValue();
    }
}

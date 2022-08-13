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

    public int reverse2(int x) {

        long result=0;
        while(x!=0) {
            result=result*10+x%10;
            x=x/10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)result;
        }
    }
}

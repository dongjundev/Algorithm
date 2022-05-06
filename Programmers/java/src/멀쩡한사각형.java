import java.math.BigInteger;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = Long.valueOf(w)*Long.valueOf(h)-(Long.valueOf(w)+Long.valueOf(h)-gcdCal(w,h));
        return answer;
    }

    public int gcdCal(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);

        return gcd.intValue();
    }
}

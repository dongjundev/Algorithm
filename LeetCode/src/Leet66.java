import java.util.Arrays;

public class Leet66 {
    public int[] plusOne(int[] digits) {
        int idx = digits.length-1;
        int carry = 1;

        while (idx >= 0 && carry == 1) {
            digits[idx] = (digits[idx] + 1) % 10;
            carry = digits[idx] == 0 ? 1 : 0;
            idx--;
        }

        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}

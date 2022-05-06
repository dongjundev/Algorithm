import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 삼진법뒤집기 {

    static List<Integer> list = new ArrayList<>();

    static public int solution(int n) {

        if(n < 3) {

            return n;
        }

        int answer = 0;

        samjinbum(n);
        Collections.reverse(list);
        System.out.println(list.toString());

        for (int i = 0; i < list.size(); i++) {
            answer += Math.pow(3, i) * list.get(i);
        }

        return answer;
    }

    static public void samjinbum(int n) {

        int remainder = n % 3;
        int share = n / 3;

        if (share < 3) {
            list.add(remainder);
            list.add(share);
            return;
        } else {
            list.add(remainder);
            samjinbum(share);
        }
    }

    public static void main(String[] args) {
        solution(45);
    }
}

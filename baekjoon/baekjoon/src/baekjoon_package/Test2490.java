package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(cal(st));
        }
    }

    static String cal(StringTokenizer st) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (st.nextToken().equals("0")) {
                cnt++;
            }
        }

        if (cnt == 1) return "A";
        else if (cnt == 2) return "B";
        else if (cnt == 3) return "C";
        else if (cnt == 4) return "D";
        else return "E";
    }
}

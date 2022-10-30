package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ch = new char[5][15];
        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            String str = br.readLine();
            max = Math.max(max, str.length());
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] == '\0') continue;
                sb.append(ch[j][i]);
            }
        }
        System.out.println(sb);
    }
}

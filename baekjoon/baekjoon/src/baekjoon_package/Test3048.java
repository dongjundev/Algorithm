package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        String l1 = br.readLine();
        String l2 = br.readLine();
        int iter = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(l1);
        l1 = String.valueOf(sb.reverse());

        String tl = l1 + l2;
        char[] ants = tl.toCharArray();
        boolean[] antDir = new boolean[ants.length];

        int i = 0;
        while (i < c1) {
            antDir[i] = true;
            ++i;
        }
        while (i < c1 + c2) {
            antDir[i] = false;
            ++i;
        }

        while (iter > 0) {
            for (int j = 0; j < ants.length-1; j++) {
                if (antDir[j] && !antDir[j + 1]) {
                    char tmp = ants[j];
                    ants[j] = ants[j + 1];
                    ants[j + 1] = tmp;

                    boolean tmp2 = antDir[j];
                    antDir[j] = antDir[j + 1];
                    antDir[j + 1] = tmp2;

                    j++;
                }
            }

            --iter;
        }

        for (char ant : ants) {
            System.out.print(ant);
        }
    }
}

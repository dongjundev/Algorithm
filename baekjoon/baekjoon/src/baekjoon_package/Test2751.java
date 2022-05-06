package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(N);

        for(int i=0; i<N; i++ ){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int answer : list)
            sb.append(answer+'\n');

        System.out.println(sb);
    }
}

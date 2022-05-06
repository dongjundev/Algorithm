package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i : temp){
            if(!hmap.containsKey(i)){
                hmap.put(i, cnt);
                cnt++;
            }
        }

        for(int i : arr){
            sb.append(hmap.get(i)+" ");
        }

        System.out.print(sb);
    }
}

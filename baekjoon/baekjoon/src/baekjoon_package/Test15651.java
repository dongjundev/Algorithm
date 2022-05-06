package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test15651 {
    public static int N,M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(M==depth){
            for(int val : arr)
                sb.append(val+" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }
}

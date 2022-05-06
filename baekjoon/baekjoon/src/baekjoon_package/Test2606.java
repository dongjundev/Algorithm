package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2606 {
    public static int N,M;
    public static int[][] arr;
    public static boolean[] visit;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int start){
        visit[start] = true;
        for (int i=1; i<N+1; i++){
            if(arr[start][i]==1 && visit[i]!=true){
                cnt++;
                dfs(i);
            }
        }
        return;
    }
}

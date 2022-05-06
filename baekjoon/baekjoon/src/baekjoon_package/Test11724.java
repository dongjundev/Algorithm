package baekjoon_package;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test11724 {
    static int N,M,count=0;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visit = new boolean[N+1];

        for(int i=1; i<=N; i++){
            if(visit[i]==true)
                continue;
            dfs(i);
            count++;
        }

        System.out.println(count);
    }

    static void dfs(int start){
        visit[start] = true;

        for(int i=1; i<N+1; i++){
            if(arr[start][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }
}

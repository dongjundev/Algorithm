package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1303 {
    public static int N,M,c, b=0, w=0;
    public static boolean[][] visit;
    public static char[][] arr;
    public static int dx[] = {0, 0, -1, 1};
    public static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j]){
                    c=0;
                    dfs(arr[i][j],i,j);

                    if(arr[i][j]=='W')
                        w+=(c*c);
                    else
                        b+=(c*c);
                }
            }
        }

        System.out.println(w+" "+b);
    }

    public static void dfs(char ch, int row, int col){
        visit[row][col] = true;
        c++;
        //이동
        for(int i=0; i<dx.length; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];

            //배열 범위 벗어나는가?
            if(nx >= N || nx < 0 || ny >= M || ny <0)
                continue;
            //이미 방문했던 곳인가?
            if(visit[nx][ny])
                continue;
            //ch이 다른 값인가?
            if(arr[nx][ny] != ch)
                continue;


            dfs(ch, nx, ny);
        }
    }
}

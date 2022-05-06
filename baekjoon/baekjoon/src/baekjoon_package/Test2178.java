package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2178 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int N, M;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(arr[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();

        q.offer(new Location(x, y));
         visit[x][y] = true;

         while(!q.isEmpty()){
             Location now = q.poll();

             for(int i=0; i<dx.length; i++){
                 int nextX = now.x+dx[i];
                 int nextY = now.y+dy[i];

                 if(nextX < N && nextY <M && nextX>-1 && nextY>-1 && visit[nextX][nextY] == false && arr[nextX][nextY] == 1){
                     q.offer(new Location(nextX,nextY));
                     visit[nextX][nextY] = true;
                     arr[nextX][nextY] = arr[now.x][now.y]+1;
                 }
             }
         }
    }
}

class Location{
    int x,y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

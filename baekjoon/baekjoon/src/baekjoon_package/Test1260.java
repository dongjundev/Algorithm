package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1260 {
    public static int N, M, start;
    public static int[][] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(start);

        visit = new boolean[N+1];
        System.out.println();

        bfs();
    }

    public static void dfs(int depth){
        visit[depth] = true;
        System.out.print(depth + " ");

        for(int i=1; i<=N; i++){
            if(arr[depth][i]==1 && visit[i]==false){
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start); //시작점도 Queue에 넣어야 함
        visit[start] = true;
        System.out.print(start + " ");

        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= N; j++) {
                if(arr[temp][j] == 1 && visit[j] == false) {
                    queue.offer(j);
                    visit[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}

package baekjoon_package;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test1697 {
    private static int N, K, cnt = 0;
    private static int[] arr = new int[100001];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        arr[N] = 0;
        bfs(N);
        System.out.println(arr[K]);
    }

    public static void bfs(int n) {
        if(n==K)
            return;

        q.offer(n);

        while (!q.isEmpty()){
            int loc = q.poll();

            if(loc+1<100001 && arr[loc+1]==0){
                arr[loc+1] = arr[loc]+1;
                q.offer(loc+1);
            }
            if(loc>0 && arr[loc-1]==0){
                arr[loc-1] = arr[loc]+1;
                q.offer(loc-1);
            }
            if(loc*2<100001 && arr[loc*2]==0){
                arr[loc*2] = arr[loc]+1;
                q.offer(loc*2);
            }
        }
        return;
    }
}




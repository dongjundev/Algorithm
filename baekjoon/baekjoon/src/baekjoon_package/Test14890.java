package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14890 {

    static int cnt;
    static int N;
    static int L;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            if (canGo(i, 0, 0))
                cnt++;

            if (canGo(0, i, 1))
                cnt++;
        }

        System.out.println(cnt);
    }

    // 한 줄이 경사로인지 확인 f = 0 이면 행검사, f = 1 이면 열검사
    static boolean canGo(int x, int y, int f) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];     // 경사로가 이미 놓여있는지 체크

        // 알아보기 쉽게 height 배열에 옮기기
        for (int i=0; i<N; i++) {
            height[i] = (f == 0) ? arr[x][y+i] : arr[x+i][y];
        }

        for (int i=0; i<N-1; i++) {
            // 높이가 같으면 패스
            if (height[i] == height[i+1]) {
                continue;
            }

            if (Math.abs(height[i] - height[i+1]) > 1) {
                return false;
            }

            // 내려가야되는 경우
            if (height[i] - 1 == height[i+1]) {
                for (int j=i+1; j<=i+L; j++) {
                    // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
                    if (j >= N || height[i+1] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 올라가야되는 경우
            else if (height[i] + 1 == height[i+1]) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}

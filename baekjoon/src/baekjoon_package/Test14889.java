package baekjoon_package;

import java.util.Scanner;

public class Test14889 {

    private static int n;
    private static int[][] arr;
    private static boolean[] visited;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(MIN);
    }

    private static void dfs(int index, int cnt) {
        if (cnt == n/2) {
            cal();
            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void cal() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] == true && visited[j] == true) {
                    startSum += arr[i][j];
                    startSum += arr[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    linkSum += arr[i][j];
                    linkSum += arr[j][i];
                }
            }
        }

        int dif = Math.abs(startSum - linkSum);

        if (dif == 0) {
            System.out.println(dif);
            System.exit(0);
        }

        MIN = Math.min(MIN, dif);
    }

}

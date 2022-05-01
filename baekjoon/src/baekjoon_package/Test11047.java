package baekjoon_package;

import java.util.Scanner;

public class Test11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        int cnt = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n - 1; i > -1; i--) {
            if (arr[i] > k) {
                continue;
            } else if (k == 0) {
                break;
            }
            cnt += k / arr[i];
            k = k % arr[i];
        }

        System.out.println(cnt);
    }
}

package baekjoon_package;

import java.util.Scanner;

public class Test2630 {

    static int blue = 0, white = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                blue++;
            } else if (arr[row][col] == 0) {
                white++;
            }
            return;
        }

        size = size / 2;
        partition(row + size, col, size); //3사분면
        partition(row, col, size); //2사분면
        partition(row, col + size, size); //1사분면
        partition(row + size, col + size, size); //4분면
    }

    private static boolean colorCheck(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[row][col] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

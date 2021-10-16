package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int one : arr)
            a+=one;

        a = a/N;
        b = arr[N/2+1];
        c = 0;
        d = arr[N-1]-arr[0];
    }
}

package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Integer[] adp = new Integer[N];
        Integer[] ddp = new Integer[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            adp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && adp[j] + 1 > adp[i]) {
                    adp[i] = adp[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            ddp[i] = 1;

            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && ddp[j] + 1 > ddp[i]) {
                    ddp[i] = ddp[j] + 1;
                }
            }
        }

        Integer[] sdp = new Integer[N];

        for (int i = 0; i < N; i++) {
            sdp[i] = adp[i] + ddp[i] - 1;
        }

        int result = Arrays.stream(sdp).mapToInt(p -> p).max().getAsInt();

        System.out.println(result);
    }
}

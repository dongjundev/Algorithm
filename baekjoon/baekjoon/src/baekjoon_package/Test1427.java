package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Test1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Integer[] arr = new Integer[input.length()];

        for(int i=0; i<input.length(); i++){
            arr[i] = input.charAt(i)-'0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int x : arr)
            System.out.print(x);
    }
}

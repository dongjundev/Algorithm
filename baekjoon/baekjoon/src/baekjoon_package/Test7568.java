package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = height;
        }

        for(int i=0; i<N; i++){
            int rank = 0;
            for(int j=0; j<N; j++){
                if(i==j)
                    continue;

                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1])
                    rank++;
            }
            System.out.println(rank);
        }
    }
}


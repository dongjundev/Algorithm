package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test2980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = 0;
        int curLoc = 0;
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<TrafficLigth> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new TrafficLigth(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (TrafficLigth o : list) {
            time += o.loc - curLoc;
            curLoc = o.loc;

            int cycle = time % (o.redTime + o.greenTime);
            if (cycle < o.redTime) {
                time += o.redTime - cycle;
            }
        }

        time += L - curLoc;

        System.out.println(time);
    }

    static class TrafficLigth {
        int loc;
        int redTime;
        int greenTime;

        public TrafficLigth(int loc, int redTime, int greenTime) {
            this.loc = loc;
            this.redTime = redTime;
            this.greenTime = greenTime;
        }
    }
}

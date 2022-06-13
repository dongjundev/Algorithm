import java.util.LinkedList;
import java.util.Queue;

public class 배달 {

    static int answer = 0;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        answer = 0;
        visited = new boolean[N+1];

        bfs(road, 1, K);

        return answer;
    }

    private void bfs(int[][] road, int start, int limitTime) {
        Queue<Home> q = new LinkedList<>();
        q.offer(new Home(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Home h = q.poll();
            answer++;

            for (int i = 0; i < road.length; i++) {
                if (road[i][0] == h.loc && road[i][2] + h.time <= limitTime && visited[road[i][1]] == false) {
                    q.offer(new Home(road[i][1], h.time + road[i][2]));
                    visited[road[i][1]] = true;
                } else if (road[i][1] == h.loc && road[i][2] + h.time <= limitTime && visited[road[i][0]] == false) {
                    q.offer(new Home(road[i][0], h.time + road[i][2]));
                    visited[road[i][0]] = true;
                }
            }
        }
    }

    class Home{
        int loc;
        int time;

        public Home(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Home{" +
                    "loc=" + loc +
                    ", time=" + time +
                    '}';
        }
    }
}

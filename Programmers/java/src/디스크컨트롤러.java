import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else
                    return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> readyQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int answer = 0;
        int time = jobs[0][0];
        readyQ.offer(jobs[0]);
        int idx = 1;

        while (!readyQ.isEmpty()) {
            int[] poll = readyQ.poll();
            time += poll[1];
            answer += time - poll[0];

            while (idx < jobs.length && jobs[idx][0] <= time) {
                readyQ.offer(jobs[idx++]);
            }

            if (idx < jobs.length && readyQ.isEmpty()) {
                time = jobs[idx][0];
                readyQ.offer(jobs[idx++]);
            }
        }

        return answer / jobs.length;
    }
}


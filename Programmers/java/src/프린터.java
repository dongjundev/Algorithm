import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public int solution(int[] priorities, int location) {

        int answer = 0;
        Queue<Task> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que.add(new Task(priorities[i], i));
        }

        while (!que.isEmpty()) {

            boolean flag = false;
            Task cur = que.poll();

            for (Task t : que) {
                if (t.priority > cur.priority) {
                    flag = true;
                }
            }

            if (flag) {
                que.add(cur);
            } else {
                answer++;
                if (location == cur.location) {
                    return answer;
                }
            }
        }

        return answer;
    }

    class Task {
        int priority;
        int location;

        public Task(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}

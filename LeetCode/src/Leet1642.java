import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int maxIdx = 0;

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 1; i < heights.length && bricks >= 0; i++) {   //bricks 갯수 주의!!
            if (heights[i] <= heights[i - 1]) {
                maxIdx = i;
            } else {
                int diff = heights[i] - heights[i - 1];
                bricks -= diff;
                q.offer(diff);

                while (bricks < 0 && ladders > 0 && !q.isEmpty()) {     //bricks 갯수 주의!!
                    int poll = q.poll();
                    bricks += poll;
                    ladders--;
                }

                if (bricks >= 0) {
                    maxIdx = i;
                }
            }
        }

        return maxIdx;
    }
}

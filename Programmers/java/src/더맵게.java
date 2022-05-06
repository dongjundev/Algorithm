import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int one : scoville){
            heap.offer(one);
        }

        while(heap.peek() < K){
            if(heap.size() < 2) return -1;
            int f1 = heap.poll();
            int f2 = heap.poll();

            int newFood = f1 + (f2 * 2);
            heap.offer(newFood);
            answer++;
        }

        return answer;
    }
}

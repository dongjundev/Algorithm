import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sumWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {

            int truck = truck_weights[i];

            while (true) {
                if (bridge.size() == bridge_length) {
                    sumWeight -= bridge.poll();
                } else {
                    if (sumWeight + truck <= weight) {
                        bridge.offer(truck);
                        sumWeight += truck;
                        time++;
                        break;
                    } else {
                        bridge.offer(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}

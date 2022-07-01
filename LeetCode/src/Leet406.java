import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else return b[0] - a[0];
        });

        int[][] answer = new int[people.length][2];
        List<int[]> list = new ArrayList<>();

        for (int[] arr : people) {
            list.add(arr[1], arr);
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

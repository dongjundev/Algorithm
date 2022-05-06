import java.util.ArrayList;
import java.util.List;

public class 폰켓몬 {
    public int solution(int[] nums) {

        int answer = 0;
        List<Integer> list = new ArrayList<>(nums.length/2);

        for (int num : nums) {
            if (list.size() == nums.length/2) {
                break;
            }

            if (!list.contains(num)) {
                list.add(num);
                answer++;
            }
        }

        return answer;
    }
}

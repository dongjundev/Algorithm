import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 로또의최고순위최저순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int[] rank = {6,6,5,4,3,2,1};
        List<Integer> winList = new ArrayList<>();
        int zero_cnt = 0;
        int correct_cnt = 0;

        for (int i = 0; i < win_nums.length; i++) {
            winList.add(win_nums[i]);
        }

        for (int one : lottos) {
            if (one == 0) {
                zero_cnt++;
                continue;
            }

            if (winList.contains(one))
                correct_cnt++;
        }

        answer[0] = rank[correct_cnt + zero_cnt];
        answer[1] = rank[correct_cnt];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19})));
    }
}

import java.util.ArrayList;
import java.util.List;

public class 주식가격 {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;

            if (i == prices.length - 1) {
                list.add(0);
                break;
            }

            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    list.add(cnt);
                    break;
                } else if (j == prices.length - 1) {
                    list.add(cnt);
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

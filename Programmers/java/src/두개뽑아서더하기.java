import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        int[] answer = new int[list.size()];

        int size = 0;
        for (int one : list) {
            answer[size++] = one;
        }

        Arrays.sort(answer);

        return answer;
    }
}

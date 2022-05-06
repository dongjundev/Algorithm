import java.util.Arrays;

public class 예산 {

    public int solution(int[] d, int budget) {

        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for (int one : d) {
            sum += one;
            if (sum > budget) {
                break;
            }
            answer++;
        }

        return answer;
    }
}

public class 없는숫자더하기 {
    public int solution(int[] numbers) {

        int answer = 45;

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}

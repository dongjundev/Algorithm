public class 조이스틱 {
    public int solution(String name) {

        int answer = 0;
        int length = name.length();
        int index = 0;
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            //상하
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            //중복 'A'의 개수
            index = i + 1;
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            //좌우 비교
            move = Math.min(move, length - index + i * 2);

            //반대로 먼저 갔을때 ex)BBBBAAAAAAAB
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }
}

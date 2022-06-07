public class 예상대진표 {
    public int solution(int n, int a, int b)
    {

        int answer = 0;
        int x = a;
        int y = b;

        while (x != y) {
            answer++;

            x = recur(x);
            y = recur(y);
        }

        return answer;
    }

    public int recur(int a) {
        if (a % 2 == 0) {
            return a/2;
        }
        else
            return (a+1)/2;
    }
}

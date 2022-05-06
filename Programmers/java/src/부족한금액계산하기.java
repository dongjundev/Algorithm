public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {

        long sumPrice = 0;
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            sumPrice += i * price;
        }

        if (sumPrice - money < 0) {
            answer = 0;
        }
        else
            answer = sumPrice - money;


        return answer;
    }
}

public class Leet121 {

    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                answer = Math.max(answer, prices[i] - minValue);
            }
        }

        return answer;
    }
}

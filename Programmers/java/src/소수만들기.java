public class 소수만들기 {
    public int solution(int[] nums) {

        int answer = 0;
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    num = nums[i] + nums[j] + nums[k];
                    if (num >= 2) {
                        if (sosu(num)) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public boolean sosu(int num) {

        if (num == 2) {
            return true;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

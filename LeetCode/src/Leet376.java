public class Leet376 {
    public int wiggleMaxLength(int[] nums) {
        String f = null;
        int answer = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (f == null) {
                if (nums[i] - nums[i + 1] > 0) {
                    f = "m";
                    answer++;
                } else if (nums[i] - nums[i + 1] < 0) {
                    f = "p";
                    answer++;
                }
            } else if (f.equals("p")) {
                if (nums[i] - nums[i + 1] > 0) {
                    f = "m";
                    answer++;
                }
            } else if (f.equals("m")) {
                if (nums[i] - nums[i + 1] < 0) {
                    f = "p";
                    answer++;
                }
            }
        }

        return answer;
    }
}

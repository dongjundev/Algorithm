import java.util.Arrays;

public class Leet128 {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        int cnt = 1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                cnt++;
            } else if (nums[i - 1] == nums[i]) {
                continue;
            } else {
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
        }

        answer = Math.max(answer, cnt);
        return answer;
    }
}

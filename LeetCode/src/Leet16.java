import java.util.Arrays;

public class Leet16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        if (nums[0] == 0 && nums[n - 1] == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int dif = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int abs = Math.abs(target - sum);
                dif = Math.min(dif, abs);

                if (dif == abs) {
                    result = sum;
                }

                if (sum > target) {
                    end --;
                } else if (sum < target) {
                    start++;
                } else
                    return sum;
            }
        }
        return result;
    }
}

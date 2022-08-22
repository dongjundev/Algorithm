import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();

        if (nums == null || nums.length < 3) {
            return new ArrayList<>(set);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];

                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else set.add(List.of(nums[i], nums[start++], nums[end--]));
            }
        }

        return new ArrayList<>(set);
    }
}

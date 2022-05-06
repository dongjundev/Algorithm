import java.util.Arrays;

public class Test581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);
        int start = 0, end = 0;
        boolean startCheck = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedArr[i]) {
                end = i;
                if (!startCheck) {
                    start = i;
                    startCheck = true;
                }
            }
        }

        if (end == 0) {
            return 0;
        }

        return end - start + 1;
    }
}

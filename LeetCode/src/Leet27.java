import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leet27 {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        nums= Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }

        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        return idx;
    }
}

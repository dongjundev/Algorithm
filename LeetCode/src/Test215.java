import java.util.Arrays;
import java.util.Collections;

public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, Collections.reverseOrder());

        return newNums[k-1];
    }
}

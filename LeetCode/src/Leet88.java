import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Leet88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }
}

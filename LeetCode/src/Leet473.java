import java.util.Arrays;
import java.util.Comparator;

public class Leet473 {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int sum = Arrays.stream(nums).sum();
        if (sum%4 != 0) return false;

        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++){
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] bucket = new int[4];
        return dfs(0, newNums, bucket, sum / 4);
    }

    private boolean dfs(int index, Integer[] nums, int[] bucket, int target){
        if (index >= nums.length){
            return bucket[0] == target && bucket[1] == target && bucket[2] == target && bucket[3] == target;
        }

        for (int i = 0; i<4; i++){
            if (bucket[i] + nums[index] > target){
                continue;
            }
            bucket[i] += nums[index];
            if (dfs(index + 1, nums, bucket, target)){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }
}

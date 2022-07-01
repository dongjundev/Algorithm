import java.util.*;

public class Leet462 {
    public int minMoves2(int[] nums) {
        int pic = 0;
        int cnt = 0;

        Arrays.sort(nums);
        pic = nums.length/2;

        for(int i : nums){
            if(i == nums[pic])
                continue;

            cnt += Math.abs(nums[pic] - i);
        }

        return cnt;
    }
}

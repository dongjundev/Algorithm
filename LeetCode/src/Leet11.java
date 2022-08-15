public class Leet11 {
    public int maxArea(int[] height) {
        int max = 0;
        int right = height.length - 1;
        int left = 0;
        int vertical = 0;
        int horizontal = 0;

        while (left != right) {
            vertical = Math.min(height[left], height[right]);
            horizontal = right - left;

            max = Math.max(max, vertical * horizontal);

            if (height[left] > height[right]) {
                right--;
            } else left++;
        }

        return max;
    }
}

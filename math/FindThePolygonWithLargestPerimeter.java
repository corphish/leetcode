// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefix = new long[nums.length];
        long max = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] + nums[i];
            }

            if (i > 1) {
                if (nums[i] < prefix[i - 1]) {
                    max = prefix[i];
                }
            }
        }

        return max;
    }
}
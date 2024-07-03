// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 3) {
            return 0;
        }

        int min = nums[nums.length - 1] - nums[0];
        int l = 0, r = nums.length - 4;

        for (; r < nums.length; r++, l++) {
            min = Math.min(min, nums[r] - nums[l]);
        }

        return min;
    }
}
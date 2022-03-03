// https://leetcode.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // If length less than 3, there cannot be any slices.
        if (nums.length < 3) return 0;
        
        // dp array, with 0, 1 value being 0
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        
        // Rolling diff
        int diff = 0, i = 0, roll = 0;
        
        // Find the first i, where nums[i], nums[i + 1] and nums[i + 2] is a slice.
        for (; i < nums.length - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                diff = nums[i + 2] - nums[i + 1];
                dp[i + 2] = 1;
                roll = 1;
                break;
            }
        }
        
        for (i = i + 1; i < nums.length - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == diff) {
                dp[i + 2] = dp[i + 1] + (++roll);
            } else {
                dp[i + 2] = dp[i + 1];
                roll = 0;
                diff = nums[i + 2] - nums[i + 1];
            }
        }
        
        return dp[nums.length - 1];
    }
}
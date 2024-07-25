// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                dp[i] = 0;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= target) {
                        int r = dp[j];
                        if (r != -1)
                            dp[i] = Math.max(dp[i], 1 + r);
                    }
                }
            }
        }

        return dp[0];
    }

    int max(int[] nums, int i, int target) {
        if (i == nums.length - 1) {
            return 0;
        }

        int max = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                int r = max(nums, j, target);
                if (r != -1)
                    max = Math.max(max, 1 + r);
            }
        }

        return max;
    }
}
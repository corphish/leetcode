// https://leetcode.com/problems/target-sum/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][4001];
        return count(nums, 0, 0, target, dp);
    }

    int count(int[] nums, int i, int sum, int target, int[][] dp) {
        if (sum == target && i == nums.length) {
            return 1;
        }

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][sum + 1000] != 0) {
            return dp[i][sum + 1000];
        }

        dp[i][sum + 1000] = count(nums, i + 1, sum + nums[i], target, dp) + count(nums, i + 1, sum - nums[i], target, dp);
        return dp[i][sum + 1000];
    }
}
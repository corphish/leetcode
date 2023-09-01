// https://leetcode.com/problems/partition-equal-subset-sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x: nums) sum += x;
        int[][] memo = new int[nums.length][sum + 1];
        return check(nums, 0, sum, 0, memo);
    }

    boolean check(int[] nums, int i, int totalSum, int currSum, int[][] memo) {
        if (totalSum == currSum) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        if (memo[i][currSum] != 0) {
            return memo[i][currSum] == 1;
        }

        boolean r = check(nums, i + 1, totalSum, currSum, memo) || 
            check(nums, i + 1, totalSum - nums[i], currSum + nums[i], memo);
        memo[i][currSum] = r ? 1 : 2;
        return r;
    }
}
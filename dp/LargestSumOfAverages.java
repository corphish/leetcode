// https://leetcode.com/problems/largest-sum-of-averages
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] memo = new double[nums.length][k + 1];
        return max(nums, 0, k, memo);
    }

    double max(
        int[] nums,
        int start,
        int k,
        double[][] memo
    ) {
        if (k == 0 && start < nums.length) {
            return Integer.MIN_VALUE;
        }

        if (k == 0) {
            return 0;
        }

        if (start >= nums.length) {
            return Integer.MIN_VALUE;
        }

        if (memo[start][k] != 0) {
            return memo[start][k];
        }

        double sum = 0;
        double max = 0;
        for (int i = start, cnt = 1; i < nums.length; i++, cnt++) {
            sum += nums[i];

            // Either be happy with this partition
            max = Math.max(max, sum/cnt + max(nums, i + 1, k - 1, memo));

            // Or continue with this partition
        }

        memo[start][k] = max;
        return max;
    }
}
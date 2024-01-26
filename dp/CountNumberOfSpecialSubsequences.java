// https://leetcode.com/problems/count-number-of-special-subsequences
class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int[][] dp = new int[nums.length + 1][4];
        int mod = 1000000007;

        for (int i = nums.length; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                int last = j - 1;
                if (i == nums.length) {
                    dp[i][j] = last == 2 ? 1 : 0;
                    continue;
                }

                dp[i][j] += dp[i + 1][j];
                dp[i][j] %= mod;
                if (nums[i] - last == 1 || nums[i] - last == 0) {
                    dp[i][j] += dp[i + 1][nums[i] + 1];
                    dp[i][j] %= mod;
                }
            }
        }

        return dp[0][0];
    }

    int count(int[] nums, int i, int last) {
        if (i == nums.length) {
            return last == 2 ? 1 : 0;
        }

        int count = count(nums, i + 1, last);

        if (nums[i] - last == 1 || nums[i] - last == 0) {
            count += count(nums, i + 1, nums[i]);
        }

        return count;
    }
}
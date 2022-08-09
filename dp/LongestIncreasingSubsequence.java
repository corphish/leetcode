// https://leetcode.com/problems/longest-increasing-subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        int max = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        for (int x: dp) max = Math.max(max, x);
        
        return max;
    }
    
    int lis(int[] nums, int n) {
        if (n == 0) {
            return 1;
        }
        
        int max = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[n]) {
                max = Math.max(max, 1 + lis(nums, i));
            }
        }
        
        return max;
    }
}
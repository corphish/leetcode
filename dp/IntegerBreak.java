class Solution {
    // Logic: dp[2] = 1
    // Starting with n = 3, dp[n] will be max of j * dp[i - j], (where j runs from 2 to i, i being iterator variable from 2..n) and j * (i - j)
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 2; i - j >= 0; j++) {
                max = Math.max(max, j * dp[i - j]);
                max = Math.max(max, j * (i - j));
            }
            
            dp[i] = max;
        }
        
        return dp[n];
    }
}
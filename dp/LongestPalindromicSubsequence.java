// https://leetcode.com/problems/longest-palindromic-subsequence
/**
 * if s[i] == s[j]
 * Then longest palindrome length will be 2 (i and j) + previously observed longest between i and j
 * else
 * max(dp[i][j-1],dp[i+1][j],dp[i+1][j-1])
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i][j - 1],
                        Math.max(dp[i + 1][j], dp[i + 1][j - 1])
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}
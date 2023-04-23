// https://leetcode.com/problems/solving-questions-with-brainpower/
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            dp[i] = questions[i][0];
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(
                Math.max(dp[i], safeGet(dp, i + 1)), // Next question
                dp[i] + safeGet(dp, 1 + i + questions[i][1])
            );
        }

        return dp[0];
    }

    long safeGet(long[] arr, int ix) {
        if (ix >= arr.length) return 0;
        return arr[ix];
    }
}
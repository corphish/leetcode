// https://leetcode.com/problems/count-ways-to-build-good-strings
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1000000007;

        for (int len = high; len >= 0; len--) {
            dp[len] = len >= low && len <= high ? 1 : 0;

            if (len + zero <= high) {
                dp[len] += dp[len + zero];
            }

            if (len + one <= high) {
                dp[len] += dp[len + one];
            }

            dp[len] %= mod;
        }

        return dp[0];
    }

    int count(
        int low, int high,
        int zero, int one,
        int len
    ) {
        if (len > high) {
            return 0;
        }

        int count = len >= low && len <= high ? 1 : 0;
        return count + count(low, high, zero, one, len + zero) + count(low, high, zero, one, len + one); 
    }
}
// https://leetcode.com/problems/count-ways-to-build-good-strings
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        long mod = 1000000007;

        dp[0] = 1;

        for (int i = 0; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
            }

            if (i - one >= 0) {
                dp[i] += dp[i - one];
            }

            dp[i] %= mod;
        }

        long count = 0;
        for (int i = low; i <= high; i++) {
            count += dp[i];
        }

        return (int) (count % mod);
    }
}
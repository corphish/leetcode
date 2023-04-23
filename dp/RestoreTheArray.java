// https://leetcode.com/problems/restore-the-array
class Solution {
    public int numberOfArrays(String s, int k) {
        char[] num = s.toCharArray();
        int n = num.length;
        long[] dp = new long[n + 1];

        dp[n] = 1;

        if (num[n - 1] != '0') {
            dp[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            int digit = num[i] - '0';

            if (digit == 0 || digit > k) {
                continue;
            }            

            dp[i] = dp[i + 1];
            long x = digit;
            for (int j = i + 1; j < n; j++) {
                x = x * 10 + (num[j] - '0');
                if (x <= k) {
                    dp[i] += dp[j + 1];
                    dp[i] %= 1000000007;
                } else {
                    break;
                }
            }
        }

        return (int) dp[0];
    }
}
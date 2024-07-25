// https://leetcode.com/problems/number-of-ways-to-select-buildings
class Solution {
    public long numberOfWays(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return dp(arr);
    }

    long dp(int[] arr) {
        long[][][] dp = new long[arr.length + 1][3][4];
        
        for (int i = arr.length; i >= 0; i--) {
            for (int last = 0; last < 3; last++) {
                for (int len = 3; len >= 0; len--) {
                    if (len == 3) {
                        dp[i][last][len] = 1;
                    } else if (i == arr.length) {
                        dp[i][last][len] = 0;
                    } else {
                        long count = 0;

                        if (arr[i] != last) {
                            count += dp[i + 1][arr[i]][len + 1];
                        }

                        count += dp[i + 1][last][len];
                        dp[i][last][len] = count;
                    }                    
                }
            }
        }

        return dp[0][2][0];
    }

    long count(
        int[] arr,
        int i, int last, int len
    ) {
        if (len == 3) {
            return 1;
        }

        if (i == arr.length) {
            return 0;
        }

        long count = 0;

        if (arr[i] != last) {
            count += count(arr, i + 1, arr[i], len + 1);
        }

        count += count(arr, i + 1, last, len);
        return count;
    }
}
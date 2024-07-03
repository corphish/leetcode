// https://leetcode.com/problems/longest-ideal-subsequence
class Solution {
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length() + 1][27];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int last = 0; last < 27; last++) {
                int max = 0;
                if (last == 0 || Math.abs(s.charAt(i) - 96 - last) <= k) {
                    max = 1 + dp[i + 1][s.charAt(i) - 96];
                }

                max = Math.max(max, dp[i + 1][last]);
                dp[i][last] = max;
            }
        }

        return dp[0][0];

        // return max(s.toCharArray(), k, 0, 0);
    }

    int max(
        char[] arr,
        int k,
        int i,
        int last
    ) {
        if (i >= arr.length) {
            return 0;
        }

        int max = 0;

        // Consider this index if it is the first one or the diff with last one satisfies
        if (last == 0 || Math.abs(arr[i] - last) <= k) {
            max = 1 + max(arr, k, i + 1, arr[i]);
        }

        max = Math.max(max, max(arr, k, i + 1, last));
        return max;
    }
}
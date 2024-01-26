// https://leetcode.com/problems/longest-common-subsequence
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        // int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int[] curr = new int[s2.length() + 1];
        int[] prev = curr.clone();

        for (int x = s1.length() - 1; x >= 0; x--) {
            for (int y = s2.length() - 1; y >= 0; y--) {
                curr[y] = 0;
                if (s1.charAt(x) == s2.charAt(y)) {
                    curr[y] = 1 + prev[y + 1];
                }

                curr[y] = Math.max(curr[y], prev[y]);
                curr[y] = Math.max(curr[y], curr[y + 1]);
            }

            System.arraycopy(curr, 0, prev, 0, curr.length);
        }

        //return dp[0][0];
        return curr[0];
    }

    int max(
        String s1,
        String s2,
        int x,
        int y
    ) {
        if (x >= s1.length() || y >= s2.length()) {
            return 0;
        }

        int max = 0;
        if (s1.charAt(x) == s2.charAt(y)) {
            max = Math.max(max, 1 + max(s1, s2, x + 1, y + 1));
        }

        max = Math.max(max, max(s1, s2, x + 1, y));
        max = Math.max(max, max(s1, s2, x, y + 1));

        return max;
    }
}
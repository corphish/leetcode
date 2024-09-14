// https://leetcode.com/problems/strange-printer/
class Solution {
    final int INF = Integer.MAX_VALUE / 10;

    public int strangePrinter(String s) {
        int[][][] dp = new int[s.length() + 1][s.length()][27];
        for (int start = s.length(); start >= 0; start--) {
            for (int end = 0; end < s.length(); end++) {
                for (int c = 0; c < 27; c++) {
                    int currChar = c, min = INF;
                    if (start > end || start >= s.length()) {
                        dp[start][end][c] = 0;
                    } else if ((currChar = s.charAt(start) - 'a') == c) {
                        dp[start][end][c] = dp[start + 1][end][c];
                    } else {
                        for (int j = start; j <= end; j++) {
                            min = Math.min(min, 1 + dp[start + 1][j][currChar] + dp[j + 1][end][c]);
                        }

                        dp[start][end][c] = min;
                    }
                }
            }
        }

        return dp[0][s.length() - 1][26];
    }

    int min(
            String s,
            int start, int end,
            int c,
            int[][][] memo) {
        if (start > end || start >= s.length()) {
            return 0;
        }

        if (memo[start][end][c] != 0) {
            return memo[start][end][c];
        }

        int currChar = s.charAt(start) - 'a', min = INF;

        // If currChar is c, we move to next position
        if (currChar == c) {
            return min(s, start + 1, end, c, memo);
        }

        // We can put s.charAt(start) till the end and move to next position
        for (int j = start; j <= end; j++) {
            min = Math.min(min, 1 + min(s, start + 1, j, currChar, memo) + min(s, j + 1, end, c, memo));
        }

        return memo[start][end][c] = min;
    }
}
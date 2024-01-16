// https://leetcode.com/problems/knight-dialer/
class Solution {
    final int[][] map = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {0, 3, 9},
        {},
        {0, 1, 7},
        {2, 6},
        {1, 3},
        {2, 4},
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
    };

    public int knightDialer(int n) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][11];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int x: map[j]) {
                        dp[i][j] += dp[i - 1][x];
                        dp[i][j] %= mod;
                    }
                }
            }
        }

        return dp[n][10];
    }
}
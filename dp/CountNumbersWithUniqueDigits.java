// https://leetcode.com/problems/count-numbers-with-unique-digits
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        return dp(n);
    }

    int set(int mask, int index) {
        return mask | (1 << index);
    }

    int get(int mask, int index) {
        return mask & (1 << index);
    }

    int dp(int n) {
        int[][][] dp = new int[n + 1][(1 << 10)][2];

        for (int i = n; i >= 0; i--) {
            for (int mask = (1 << 10) - 1; mask >= 0; mask--) {
                for (int isLeading = 0; isLeading < 2; isLeading++) {
                    if (i == n) {
                        dp[i][mask][isLeading] = 1;
                    } else {
                        int count = 0;

                        for (int j = 0; j <= 9; j++) {
                            if (get(mask, j) == 0) {
                                count += dp[i + 1][j == 0 && isLeading == 1 ? mask : set(mask, j)][j == 0
                                        && isLeading == 1 ? 1 : 0];
                            }
                        }

                        dp[i][mask][isLeading] = count;
                    }
                }
            }
        }

        return dp[0][0][1];
    }
}
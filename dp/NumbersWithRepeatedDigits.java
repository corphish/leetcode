// https://leetcode.com/problems/numbers-with-repeated-digits
class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n + 1 - dp(asArray(n));
    }

    int set(int mask, int index) {
        return mask | (1 << index);
    }

    int get(int mask, int index) {
        return mask & (1 << index);
    }

    int[] asArray(int n) {
        if (n == 0) {
            return new int[] {};
        }

        int[] arr = new int[1 + (int) Math.floor(Math.log10(n))];
        int k = arr.length - 1;

        while (n > 0) {
            arr[k--] = n % 10;
            n /= 10;
        }

        return arr;
    }

    int dp(int[] digits) {
        int[][][][] dp = new int[digits.length + 1][2][(1 << 10)][2];

        for (int i = digits.length; i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                for (int mask = (1 << 10) - 1; mask >= 0; mask--) {
                    for (int isLeading = 0; isLeading < 2; isLeading++) {
                        if (i == digits.length) {
                            dp[i][restricted][mask][isLeading] = 1;
                        } else {
                            int count = 0;

                            if (restricted == 1) {
                                for (int j = 0; j <= Math.min(9, digits[i]); j++) {
                                    if (get(mask, j) == 0) {
                                        count += dp[i + 1][j == digits[i] ? 1 : 0][j == 0 && isLeading == 1 ? mask : set(mask, j)][j == 0 && isLeading == 1 ? 1 : 0];
                                    }
                                }
                            } else {
                                for (int j = 0; j <= 9; j++) {
                                    if (get(mask, j) == 0) {
                                        count += dp[i + 1][0][j == 0 && isLeading == 1 ? mask : set(mask, j)][j == 0 && isLeading == 1 ? 1 : 0];
                                    }
                                }
                            }

                            dp[i][restricted][mask][isLeading] = count;
                        }
                    }
                }
            }
        }

        return dp[0][1][0][1];
    }

    int f(
        int[] digits,
        int i, int restricted, int mask, int isLeading,
        int num
    ) {
        if (i == digits.length) {
            return 1;
        }

        int count = 0;

        if (restricted == 1) {
            for (int j = 0; j <= Math.min(9, digits[i]); j++) {
                if (get(mask, j) == 0) {
                    count += f(
                        digits, 
                        i + 1, 
                        j == digits[i] ? 1 : 0, 
                        j == 0 && isLeading == 1 ? mask : set(mask, j), 
                        j == 0 && isLeading == 1 ? 1 : 0, 
                        num * 10 + j
                    );
                }
            }
        } else {
            for (int j = 0; j <= 9; j++) {
                if (get(mask, j) == 0) {
                    count += f(
                        digits, 
                        i + 1, 
                        0, 
                        j == 0 && isLeading == 1 ? mask : set(mask, j), 
                        j == 0 && isLeading == 1 ? 1 : 0, 
                        num * 10 + j
                    );
                }
            }
        }

        return count;
    }
}
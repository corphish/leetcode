// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones
class Solution {
    public int findIntegers(int n) {
        return dp(digits(n));
    }

    int[] digits(int n) {
        String b = Integer.toBinaryString(n);
        int[] arr = new int[b.length()];

        for (int i = 0; i < b.length(); i++) {
            arr[i] = b.charAt(i) - '0';
        }

        return arr;
    }

    int dp(int[] digits) {
        int[][][] dp = new int[digits.length + 1][2][2];
        for (int i = digits.length; i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                for (int last = 1; last >= 0; last--) {
                    if (i == digits.length) {
                        dp[i][restricted][last] = 1;
                    } else {
                        int count = 0;

                        if (restricted == 1) {
                            for (int j = 0; j <= Math.min(1, digits[i]); j++) {
                                if (j == 0 || (j == 1 && last == 0)) {
                                    count += dp[i + 1][j == digits[i] ? 1 : 0][j];
                                }
                            }
                        } else {
                            for (int j = 0; j <= 1; j++) {
                                if (j == 0 || (j == 1 && last == 0)) {
                                    count += dp[i + 1][0][j];
                                }
                            }
                        }

                        dp[i][restricted][last] = count;
                    }
                }
            }
        }

        return dp[0][1][0];
    }

    int f(
        int[] digits,
        int i, int restricted, int last
    ) {
        if (i == digits.length) {
            return 1;
        }

        int count = 0;

        if (restricted == 1) {
            for (int j = 0; j <= Math.min(1, digits[i]); j++) {
                if (j == 0 || (j == 1 && last == 0)) {
                    count += f(digits, i + 1, j == digits[i] ? 1 : 0, j);
                }
            }
        } else {
            for (int j = 0; j <= 1; j++) {
                if (j == 0 || (j == 1 && last == 0)) {
                    count += f(digits, i + 1, 0, j);
                }
            }
        }

        return count;
    }
}
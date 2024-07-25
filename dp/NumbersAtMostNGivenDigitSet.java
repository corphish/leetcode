// https://leetcode.com/problems/numbers-at-most-n-given-digit-set
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int count = 0;
        int k = 1;
        do {
            k *= 10;
            count += dp(asArray(Math.min(n, k - 1)), digits);
        } while (k <= n);
        return count;
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

    int dp(
        int[] n,
        String[] digits
    ) {
        int[][] dp = new int[n.length + 1][2];

        for (int i = n.length; i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                if (n.length == 0) {
                    dp[i][restricted] = 0;
                } else if (i == n.length) {
                    dp[i][restricted] = 1;
                } else {
                    int count = 0;
                    if (restricted == 1) {
                        for (String x: digits) {
                            int digit = x.charAt(0) - '0';
                            if (digit == n[i]) {
                                count += dp[i + 1][1];
                            } else if (digit < n[i]) {
                                count += dp[i + 1][0];
                            }
                        }
                    } else {
                        for (String x: digits) {
                            int digit = x.charAt(0) - '0';
                            count += dp[i + 1][0];
                        }
                    }

                    dp[i][restricted] = count;
                }
            }
        }

        return dp[0][1];
    }

    int f(
        int[] n,
        String[] digits,
        int i, int restricted, int num
    ) {
        if (n.length == 0) {
            return 0;
        }

        if (i == n.length) {
            return 1;
        }

        int count = 0;

        if (restricted == 1) {
            for (String x: digits) {
                int digit = x.charAt(0) - '0';
                if (digit == n[i]) {
                    count += f(n, digits, i + 1, 1, num * 10 + digit);
                } else if (digit < n[i]) {
                    count += f(n, digits, i + 1, 0, num * 10 + digit);
                }
            }
        } else {
            for (String x: digits) {
                int digit = x.charAt(0) - '0';
                count += f(n, digits, i + 1, 0, num * 10 + digit);
            }
        }

        return count;
    }
}
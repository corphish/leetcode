// https://leetcode.com/problems/number-of-beautiful-integers-in-the-range/
class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return dp(asArray(high), k) - dp(asArray(low - 1), k);
    }

    int[] asArray(int n) {
        if (n == 0) {
            return new int[] {};
        }

        int len = (int) (Math.floor(Math.log10(n)) + 1);
        int[] arr = new int[len];
        int k = len - 1;

        while (n > 0) {
            arr[k--] = n % 10;
            n /= 10;
        }

        return arr;
    }

    int dp(int[] arr, int k) {
        int[][][][][][] dp = new int[arr.length + 1][2][arr.length + 1][arr.length + 1][2][k];

        for (int i = arr.length; i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                for (int odd = arr.length - 1; odd >= 0; odd--) {
                    for (int even = arr.length - 1; even >= 0; even--) {
                        for (int isLeading = 0; isLeading < 2; isLeading++) {
                            for (int rem = k - 1; rem >= 0; rem--) {
                                if (i == arr.length) {
                                    if (odd > 0 && odd == even && rem == 0) {
                                        dp[i][restricted][odd][even][isLeading][rem] = 1;
                                    } else {
                                        dp[i][restricted][odd][even][isLeading][rem] = 0;
                                    }
                                } else {
                                    int count = 0;
                                    if (restricted == 1) {
                                        for (int j = 0; j <= arr[i]; j++) {
                                            count += dp[i + 1][j == arr[i] ? 1 : 0][j % 2 == 1 ? odd + 1 : odd][isLeading == 1 && j == 0 ? even : j % 2 == 0 ? even + 1 : even][isLeading == 1 && j == 0 ? 1 : 0][(rem * 10 + j) % k];
                                        }
                                    } else {
                                        for (int j = 0; j <= 9; j++) {
                                            count += dp[i + 1][0][j % 2 == 1 ? odd + 1 : odd][isLeading == 1 && j == 0 ? even : j % 2 == 0 ? even + 1 : even][isLeading == 1 && j == 0 ? 1 : 0][(rem * 10 + j) % k];
                                        }
                                    }

                                    dp[i][restricted][odd][even][isLeading][rem] = count;
                                }
                            }
                        }
                    }
                }
            }
        }

        return dp[0][1][0][0][1][0];
    }

    int f(
        int[] arr, int k,
        int i, int restricted,
        int odd, int even, int isLeading,
        int rem, int num
    ) {
        if (i == arr.length) {
            if (odd > 0 && odd == even && rem == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;

        if (restricted == 1) {
            for (int j = 0; j <= arr[i]; j++) {
                count += f(arr, k, i + 1, j == arr[i] ? 1 : 0, j % 2 == 1 ? odd + 1 : odd, isLeading == 1 && j == 0 ? even : j % 2 == 0 ? even + 1 : even, isLeading == 1 && j == 0 ? 1 : 0, (rem * 10 + j) % k, num * 10 + j);
            }
        } else {
            for (int j = 0; j <= 9; j++) {
                count += f(arr, k, i + 1, 0, j % 2 == 1 ? odd + 1 : odd, isLeading == 1 && j == 0 ? even : j % 2 == 0 ? even + 1 : even, isLeading == 1 && j == 0 ? 1 : 0, (rem * 10 + j) % k, num * 10 + j);
            }
        }

        return count;
    }
}
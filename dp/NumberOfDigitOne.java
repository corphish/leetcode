// https://leetcode.com/problems/number-of-digit-one/
class Solution {
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }

        int[] arr = asArray(n);
        int[][][] dp = new int[arr.length + 1][2][2 * arr.length + 1];

        for (int i = arr.length; i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                for (int sum = arr.length; sum >= 0; sum--) {
                    if (i == arr.length) {
                        dp[i][restricted][sum] = sum;
                    } else {
                        int count = 0;
                        if (restricted == 1) {
                            for (int j = 0; j <= arr[i]; j++) {
                                count += dp[i + 1][j == arr[i] ? 1 : 0][j == 1 ? sum + 1 : sum];
                            }
                        } else {
                            for (int j = 0; j <= 9; j++) {
                                count += dp[i + 1][0][j == 1 ? sum + 1 : sum];
                            }
                        }

                        dp[i][restricted][sum] = count;
                    }
                }
            }
        }

        return dp[0][1][0];
    }

    int[] asArray(int n) {
        int len = (int) (Math.floor(Math.log10(n)) + 1);
        int[] arr = new int[len];
        int k = len - 1;

        while (n > 0) {
            arr[k--] = n % 10;
            n /= 10;
        }

        return arr;
    }

    int f(
        int[] arr,
        int i, int restricted, int sum
    ) {
        if (i == arr.length) {
            return sum;
        }

        int count = 0;
        if (restricted == 1) {
            for (int j = 0; j <= arr[i]; j++) {
                count += f(arr, i + 1, j == arr[i] ? 1 : 0, j == 1 ? sum + 1 : sum);
            }
        } else {
            for (int j = 0; j <= 9; j++) {
                count += f(arr, i + 1, 0, j == 1 ? sum + 1 : sum);
            }
        }

        return count;
    }
}
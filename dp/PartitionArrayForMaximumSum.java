// https://leetcode.com/problems/partition-array-for-maximum-sum
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int max = arr[i];
            for (int j = 0; j < k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                sum = Math.max(sum, (j + 1) * max + (i - j - 1 < 0 ? 0 : dp[i - j - 1]));
            }

            dp[i] = sum;
        }

        return dp[arr.length - 1];
    }

    int max(int[] arr, int k, int i) {
        if (i < 0) {
            return 0;
        }

        int sum = arr[i];
        int max = arr[i];
        for (int j = 0; j < k && i - j >= 0; j++) {
            max = Math.max(max, arr[i - j]);
            sum = Math.max(sum, (j + 1) * max + max(arr, k, i - j - 1));
        }

        return sum;
    }
}
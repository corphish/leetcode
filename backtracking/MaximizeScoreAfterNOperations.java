// https://leetcode.com/problems/maximize-score-after-n-operations
// Kindly follow the editorial.
// Key hint that helped me is to use memo where the state of numbers in the memo array should be determined by bitmask.
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        boolean[] v = new boolean[n];
        int[][] gcdMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                gcdMap[i][j] = gcd(nums[i], nums[j]);
                gcdMap[j][i] = gcdMap[i][j];
            }
        }

        int[] memo = new int[1 << n + 1];
        Arrays.fill(memo, -1);
        return choose(n, gcdMap, 0, memo, 0);
    }

    int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }

    int kthBitOf(int n, int k) {
        return (n >> (k)) & 1;
    }

    int setKthBitOf(int n, int k) {
        return ((1 << k) | n);
    }

    int unsetKthBitOf(int n, int k) {
        return (n & (~(1 << k)));
    }

    int choose(
        int n,
        int[][] gcdMap,
        int mask,
        int[] memo,
        int k
    ) {
        if (k == n/2) {
            return 0;
        }

        // If we have memo'd the mask, return it
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int max = 0;

        // We will choose a value from the table
        // When we do that, in the next turn, we cannot choose the ith and jth row/col in the next turn
        for (int i = 0; i < n; i++) {
            if (kthBitOf(mask, i) == 1) continue;
            mask = setKthBitOf(mask, i);

            for (int j = i + 1; j < n; j++) {
                if (kthBitOf(mask, j) == 1) continue;
                mask = setKthBitOf(mask, j);
                int curr = (k + 1) * gcdMap[i][j];
                int rem = choose(n, gcdMap, mask, memo, k + 1);
                max = Math.max(max, curr + rem);
                mask = unsetKthBitOf(mask, j);
            }
            mask = unsetKthBitOf(mask, i);
        }

        memo[mask] = max;

        return max;
    }
}
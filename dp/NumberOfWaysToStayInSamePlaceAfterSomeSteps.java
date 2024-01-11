// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
class Solution {
    final int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        // We can only "steps"th index of the array, so arrLen matters only if its less than
        // steps.
        int[][] dp = new int[Math.min(arrLen, steps + 1)][steps + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return count(0, steps, arrLen, dp);
    }

    int count(int pos, int steps, int n, int[][] dp) {
        if (pos < 0 || pos == n || steps < 0) {
            return 0;
        }

        if (steps == 0 && pos == 0) {
            return 1;
        }

        if (dp[pos][steps] != -1) {
            return dp[pos][steps];
        }

        long res = 0;

        res += count(pos + 1, steps - 1, n, dp);
        res += count(pos - 1, steps - 1, n, dp);
        res += count(pos, steps - 1, n, dp);

        res %= MOD;
        dp[pos][steps] = (int) res;

        return dp[pos][steps];
    }
}